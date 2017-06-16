package delfiRu;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


/**
 * All actions on Delfi homepage
 */

public class DelfiHomePage {

    private static final Logger LOGGER = Logger.getLogger(DelfiHomePage.class);
    private static final By ARTICLE = By.xpath("//h3[contains(@class, 'top2012-title')]");
    private static final By ARTICLE_NAME = By.xpath("./a[contains(@class, 'top2012-title')]");

    BaseFunctions baseFunctions;


    public DelfiHomePage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
        LOGGER.info("Delfi Home page is loaded");
    }

    /*public void goToOurArticle() {
        baseFunctions.click(By.xpath("(/*//*[contains(@class, 'top2012-title')])[13]"));

    }*/

    /*public ArticleCommentPage getCommentPageByTitle(String title) {
        List<WebElement> articles;
        articles = baseFunctions.getAllElements(ARTICLE);

        for (WebElement we: articles) {
            if(we.findElement(ARTICLE_NAME).getText().equals(title)) {
                we.findElement(ARTICLE_NAME).click();
                return new ArticleCommentPage();
            }
        }
        return null;
    }*/

    public ArticlePage goToArticlePageByTitle(String title) {
        List<WebElement> articles = baseFunctions.getAllElements(ARTICLE);
        for (WebElement ourArticle : articles) {
            if (ourArticle.findElement(ARTICLE_NAME).getText().equals(title)) {
                ourArticle.findElement(ARTICLE_NAME).click();
                return new ArticlePage(baseFunctions);
            }
        }
        return null;
    }
}


