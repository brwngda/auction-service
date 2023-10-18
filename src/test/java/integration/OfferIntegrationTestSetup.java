package integration;

import com.example.auctionservice.dto.OfferDTO;
import com.example.auctionservice.model.Product;
import com.example.auctionservice.model.ProductCategory;

class OfferIntegrationTestSetup {

        OfferDTO createOfferDto(){
            return OfferDTO.builder()
                    .product(createProduct())
                    .price(200.0)
                    .build();
        }

    Product createProduct() {
        return Product.builder()

                .productCategory(ProductCategory.BEAUTY)
                .build();
    }


}
