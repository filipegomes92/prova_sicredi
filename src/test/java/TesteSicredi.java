import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TesteSicredi {

    private WebDriver navegador;

    @Before
    public  void  Abrenavegador(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Drivers\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegador.get("https://www.grocerycrud.com/demo/bootstrap_theme");
    }

    @Test
    public void Desafio01() throws InterruptedException {

        navegador.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        navegador.findElement(By.xpath("//*[@id=\"switch-version-select\"]/option[2]")).click();
        navegador.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[1]/div[1]/a")).click();
        navegador.findElement(By.name("customerName")).sendKeys("Teste Sicredi");
        navegador.findElement(By.name("contactLastName")).sendKeys("Teste");
        navegador.findElement(By.name("contactFirstName")).sendKeys("Filipe");
        navegador.findElement(By.name("phone")).sendKeys("51 9999-9999");
        navegador.findElement(By.name("addressLine1")).sendKeys("AV Assis Brasil,3970");
        navegador.findElement(By.name("addressLine2")).sendKeys("Torre D");
        navegador.findElement(By.name("city")).sendKeys("Porto Alegre");
        navegador.findElement(By.name("state")).sendKeys("RS");
        navegador.findElement(By.name("postalCode")).sendKeys("91000-000");
        navegador.findElement(By.name("country")).sendKeys("Brasil");
        navegador.findElement(By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/a/span")).click();
        navegador.findElement(By.name("creditLimit")).sendKeys("200");
        navegador.findElement(By.id("form-button-save")).click();
        WebElement mensagemValidacao = navegador.findElement(By.xpath("//*[@id=\"report-success\"]/p"));
        String mensagem = mensagemValidacao.getText();
        assertEquals(true,mensagem.contains("Your data has been successfully stored into the database."));


    }

    @Test
    public void Desafio02() throws InterruptedException {

        navegador.findElement(By.xpath("//*[@id=\"report-success\"]/p/a[2]")).click();
        navegador.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[1]/div[2]/a[3]")).click();
        navegador.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[1]/div[2]/a[3]/input")).sendKeys("Teste Sicredi");
        navegador.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[1]/div/input")).click();
        navegador.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[1]/div/input")).click();
        navegador.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[2]/div[1]/a")).click();

        WebElement encontrafrase = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[2]/p[2]"));
        String compara = encontrafrase.getText();
        assertEquals("Are you sure that you want to delete this 1 item?",compara);

        navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[3]/button[2]")).click();
        WebElement encontraultimafrase = navegador.findElement(By.xpath("/html/body/div[3]/span[3]/p"));
        Thread.sleep(500);
        String ultimocompara = encontraultimafrase.getText();
        assertEquals("Your data has been successfully deleted from the database.",ultimocompara);

    }

    public void ChamaDesafio01() throws InterruptedException{
        this.Desafio01();
    }
    public  void  ChamaDesafio02() throws InterruptedException{
        this.Desafio01();
        this.Desafio02();
    }
    @Test
    public void  RodaDesafio01() throws InterruptedException{
        ChamaDesafio01();
        navegador.close();
    }
    @Test
    public void RodaDesafio02() throws InterruptedException{
        ChamaDesafio02();
        navegador.quit();
    }
}
