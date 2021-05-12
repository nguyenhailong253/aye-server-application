package aye.presentation;

import aye.application.CatalogueApplicationService;
import aye.application.UserApplicationService;
import aye.domain.catalogue.Catalogue;
import aye.domain.user.Actions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/catalogue")
public class CatalogueAPI {
    private CatalogueApplicationService service;
    private UserApplicationService userService;

    public CatalogueAPI() {
        service = new CatalogueApplicationService();
        userService = new UserApplicationService();
    }

    @GetMapping("")
    public Catalogue getCatalogue() {
        return service.getCatalogue();
    }

    @PostMapping("")
    public void updateCatalogue(@RequestParam String email, @RequestBody Catalogue catalogue) {
        if (userService.isUserAuthorised(email, Actions.UPDATE_CATALOGUE))
            service.updateCatalogue(catalogue);
        else
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "User is not authorised for this action");
    }
}
