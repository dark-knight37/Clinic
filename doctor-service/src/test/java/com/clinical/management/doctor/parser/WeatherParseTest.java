package com.clinical.management.doctor.parser;

import com.clinical.management.doctor.DoctorApplication;
import com.clinical.management.doctor.domain.Weather;
import com.clinical.management.doctor.util.JsonUtil;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DoctorApplication.class)
public class WeatherParseTest {

    @InjectMocks
    private WeatherParse weatherParser;

    @Before
    public void setup() {
        initMocks(this);
    }

    @Test
    public void shouldGetWeathers() throws Exception {
        JSONObject jsonObject = JsonUtil.getWeatherJson();
        List<Weather> weathers = weatherParser.parse(jsonObject);

        assertEquals(5, weathers.size());
    }

}
