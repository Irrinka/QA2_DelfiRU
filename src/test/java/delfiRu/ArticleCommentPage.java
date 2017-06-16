package delfiRu;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

/**
 * All actions on Delfi Article Comment page
 */
public class ArticleCommentPage {

    private BaseFunctions baseFunctions;
    private static final Logger LOGGER = Logger.getLogger(ArticleCommentPage.class);
    private static final By COMMENT_PAGE_COUNTERS = By.xpath("//*[contains(@class, 'comment-thread-switcher-selected-reg ')]/a/span");
    private static final By HIDDEN_COMMENT = By.className("load-more-comments-btn-link");


    public ArticleCommentPage(BaseFunctions baseFunctions) {
        baseFunctions.waitForElement(COMMENT_PAGE_COUNTERS, 500);
        this.baseFunctions = baseFunctions;
        LOGGER.info("Article Comment page is loaded");
    }

    /*public ArticlePage goToArticlePageByTitle(String title) {
        List<WebElement> articles = baseFunctions.getAllElements(ARTICLE);
        for (WebElement ourArticle : articles) {
            if (ourArticle.findElement(ARTICLE_NAME).getText().equals(title)) {
                ourArticle.findElement(ARTICLE_NAME).click();
                return new ArticlePage(baseFunctions);
            }
        }
        return null;
    }*/

    public void toSlamHiddenComments() {
        baseFunctions.waitForElement(HIDDEN_COMMENT, 500);
        List<WebElement> hiddenComments = baseFunctions.getAllElements(HIDDEN_COMMENT);

        for (WebElement comment : hiddenComments) {
            do {
                comment.click();
            } while (comment != null);
        }
    }



    /*public Integer unRegisteredUsersCommentsCount() {
        List<WebElement> counters = baseFunctions.getAllElements(COMMENT_PAGE_COUNTERS);
        counters.get(1).click();
        return registerCommentsCount;
    }*/

    public void unRegisteredComments() {
        List<WebElement> counters = baseFunctions.getAllElements(COMMENT_PAGE_COUNTERS);
        counters.get(1).click();
    }
}
