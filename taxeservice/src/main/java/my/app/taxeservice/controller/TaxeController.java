package my.app.taxeservice.controller;

import my.app.taxeservice.bean.Terrain;
import my.app.taxeservice.bean.User;
import my.app.taxeservice.service.TaxeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Controller
@RequestMapping("/api/tax")
public class TaxeController {
    @Autowired
     TaxeService taxeService;
    @Autowired
     WebClient webClient;

    @Autowired
    public TaxeController(TaxeService taxeService, WebClient.Builder webClientBuilder) {
        this.taxeService = taxeService;
        this.webClient = webClientBuilder.baseUrl("http://localhost:8081").build();
    }

    @PostMapping("/calculateTax")
    @ResponseBody
    public double calculateTax(
            @RequestParam(name = "cin") String cin,
            @RequestParam(name = "year") Integer year,
            @RequestParam(name = "categorie_id") Integer categorie_id,
            Model model) {

        URI userUri = UriComponentsBuilder.fromPath("/api/user/byCin/%7Bcin%7D")
                .buildAndExpand(cin)
                .toUri();

        User user = webClient.get()
                .uri(userUri)
                .retrieve()
                .bodyToMono(User.class)
                .block();

        if (user == null) {
            // Gérer le cas où l'utilisateur n'est pas trouvé
            return 0;
        }

        URI terrainUri = UriComponentsBuilder.fromPath("/terrains/byUser/%7BuserId%7D")
                .buildAndExpand(user.getId())
                .toUri();

        Terrain terrain = webClient.get()
                .uri(terrainUri)
                .retrieve()
                .bodyToMono(Terrain.class)
                .block();

        if (terrain == null) {
            // Gérer le cas où le terrain n'est pas trouvé
            return 0;
        }

        Integer b = terrain.getDatedernierpaiment();

        int minYear = 2020;
        int maxYear = 2022;
        int a = (year >= minYear && year <= maxYear) ? 3 : 1;

        if (year >= b) {
            double surface = terrain.getSurface();
            double montantParMetreCarre = terrain.getCategorie().getTaux().get(0).getMontantParMetreCarre();
            double tax = a * surface * montantParMetreCarre;
            model.addAttribute("tax", tax);
            return tax;
        } else {
            return 0;
        }
    }
}
