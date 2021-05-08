package aye;

import aye.application.UserApplicationService;
import aye.domain.catalogue.CatalogueRepository;
import aye.domain.salesReport.SalesReportRepository;
import aye.domain.shoppingCart.ShoppingCartRepository;
import aye.domain.user.UserRepository;
import aye.infrastructure.InMemoryCatalogueRepository;
import aye.infrastructure.InMemorySalesReportRepository;
import aye.infrastructure.InMemoryShoppingCartRepository;
import aye.infrastructure.InMemoryUserRepository;
import aye.presentation.UserAPI;
import com.sun.net.httpserver.HttpServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.InetSocketAddress;

@SpringBootApplication
public class AyeServerApplication {

    private UserRepository userRepository;
    private ShoppingCartRepository shoppingCartRepository;
    private SalesReportRepository salesReportRepository;
    private CatalogueRepository catalogueRepository;

    public AyeServerApplication() throws IOException {
        System.out.println("Aye server");
        instantiateInMemoryRepository();
        System.out.println("Instantiated");
//        HttpServer server = HttpServer.create();
//        server.bind(new InetSocketAddress(80), 2);
//        server.createContext("/users", new UserAPI(userRepository));
//        server.start();
    }

    private void instantiateInMemoryRepository() {
        this.userRepository = new InMemoryUserRepository();
        this.shoppingCartRepository = new InMemoryShoppingCartRepository();
        this.salesReportRepository = new InMemorySalesReportRepository();
        this.catalogueRepository = new InMemoryCatalogueRepository();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AyeServerApplication.class, args);
    }
}
