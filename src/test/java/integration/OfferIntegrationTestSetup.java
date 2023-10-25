package integration;

import com.example.auctionservice.model.request.OfferRequest;
import com.example.auctionservice.model.Product;
import com.example.auctionservice.model.ProductCategory;

class OfferIntegrationTestSetup {

        OfferRequest createOfferDto(){
            return OfferRequest.builder()
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
