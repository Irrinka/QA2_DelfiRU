package delfiRu;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * In this class we will check comments amount on home page and in the article
 */


public class TestCommentsChecking {
    private static final Logger LOGGER = Logger.getLogger(TestCommentsChecking.class);
    private static final String WEB_SITE_URL = "rus.delfi.lv";
    private static final String OUR_ARTICLE = "Обыск в главном здании СГД: в отношении четы Богдановых начат уголовный процесс";
    private BaseFunctions baseFunctions = new BaseFunctions();
    WebDriver driver;
    private int commentCount;
    private static final By COMMENT_PAGE_COUNTERS = By.xpath("//*[contains(@class, 'comment-thread-switcher-selected-reg ')]/a/span");


    @Test
    public void commentTesting() {


        LOGGER.info("We are starting out test");

        LOGGER.info("We are opening rus.delfi.lv home page");
        baseFunctions.goToUrl(WEB_SITE_URL);
        DelfiHomePage homePage = new DelfiHomePage(baseFunctions);

        LOGGER.info("We are going to our article");
        ArticlePage articlePage = homePage.goToArticlePageByTitle(OUR_ARTICLE);

        LOGGER.info("Our article page is loaded");

        LOGGER.info("Getting comment count from title on article page");
        articlePage.getCommentCount();

        LOGGER.info("Comment count on article title on article page is +  ");
        //+ articlePageCommentCount);

        LOGGER.info("We are moving to article comment page (click on comment count in article title)");
        articlePage.goToCommentPage();

        ArticleCommentPage articleCommentPage = new ArticleCommentPage(baseFunctions);

        LOGGER.info("To slam the hidden to registered comments");
        //articleCommentPage.toSlamHiddenComments();

        LOGGER.info("Getting registered users comment count");
        //articleCommentPage.RegisteredComments();

        LOGGER.info("To slam the hidden to unregistered comments");
        articleCommentPage.toSlamHiddenComments();

        LOGGER.info("Getting unregistered users comment count");
        articleCommentPage.unRegisteredComments();

        LOGGER.info("Real comment count on comment page is +  ");
        //+ commentPageCommentCount);

        LOGGER.info("Checking in the title specified comment count and in comment page");

        LOGGER.info("We are closing our browser");
        baseFunctions.closeBrowser();

    }
}
