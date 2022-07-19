package bragagustavo.com.github.api.service;

import bragagustavo.com.github.api.domain.dto.ProductDto;
import bragagustavo.com.github.api.domain.entity.Product;
import bragagustavo.com.github.api.exception.ObjectNotFoundException;
import bragagustavo.com.github.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Transactional
    public Product insertProduct(Product product) {
        product.setId(null);
        return productRepository.save(product);

    }

    public Product updateProduct(Product product) {
        Product productToUpdate = find(product.getId());
        updateData(productToUpdate, product);
        return productRepository.save(productToUpdate);

    }

    public void updateData(Product productToUpdate, Product product ){
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setTitle(product.getTitle());

    }

    public Product find(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow(()-> new ObjectNotFoundException("Produto : " + id + "não encontrado: " + "nome: " +
                Product.class.getName()));


    }

    public Product fromDto(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getTitle(), productDto.getPrice());
    }

    public void deleteProduct(Integer id) {
        find(id);
        try{

            productRepository.deleteById(id);

        } catch (ObjectNotFoundException e){
            System.out.println("Objeto não encontrado para ser deletado: ");

        }
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
