package delfiRu;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * All actions on Delfi article page
 */

public class ArticlePage {

    private BaseFunctions baseFunctions;
    private static final Logger LOGGER = Logger.getLogger(ArticlePage.class);
    private static final By COUNTER = By.xpath("//*[contains(@class, 'comment-count')]");

    public ArticlePage(BaseFunctions baseFunctions) {
        baseFunctions.waitForElement(COUNTER, 1000);
        this.baseFunctions = baseFunctions;
        LOGGER.info("Article page is loaded");
    }

    public Integer getCommentCount() {
        WebElement counter = baseFunctions.getElement(COUNTER);
        String counterString = counter.getText();
        LOGGER.info("Article name is " + counterString);
        Integer count = removeChars(counterString);
        LOGGER.info("Article comment count is " + count);
        return count;
    }

    private Integer removeChars(String cuntStr) {
        return Integer.parseInt(cuntStr.substring(1, cuntStr.length()-1));
    }

    public void goToCommentPage(){
        baseFunctions.click(COUNTER);
    }
}

