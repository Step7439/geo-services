import org.junit.jupiter.api.Test;
import ru.netology.i18n.LocalizationServiceImpl;
import static ru.netology.entity.Country.RUSSIA;
import static ru.netology.entity.Country.USA;

public class Local {
    @Test
    void localization() {
        LocalizationServiceImpl loc = new LocalizationServiceImpl();
        loc.locale(USA);
        loc.locale(RUSSIA);
    }
}
