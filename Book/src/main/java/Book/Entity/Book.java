package Book.Entity;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.lang.annotation.Documented;
import java.util.Collection;

@Data
@Component
@ConfigurationProperties(prefix = "bo")
public class Book {

    private long bookId;
    @NotBlank(message = "insert name book")
    private String bookName;
    private float bookPrice;

    public Book(){};

    public Book(long i, String n, float p){
        this.bookId = i;
        this.bookName = n;
        this.bookPrice = p;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String toString(){
        return "ID: " + getBookId() + " BookName: " + getBookName() + " Price: "+ getBookPrice();
    }
}
