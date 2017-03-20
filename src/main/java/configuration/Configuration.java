package configuration;

import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.Test;

/**
 * Created by yangyu on 2017/3/9.
 */
public class Configuration {

    @Test
    public void config2XML(){
        Configurations configs = new Configurations();
        FileBasedConfigurationBuilder<XMLConfiguration> builder =  configs.xmlBuilder("/Users/yangyu/Downloads/path.xml");
        try {
            XMLConfiguration config = builder.getConfiguration();
            config.addProperty("yangyu","18");
            config.addProperty("linling","88");
            builder.save();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

}
