package org.adaschool.Weather.Service;

import org.adaschool.Weather.data.WeatherApiResponse;
import org.adaschool.Weather.data.WeatherApiResponse.Main;
import org.adaschool.Weather.data.WeatherReport;
import org.adaschool.Weather.service.WeatherReportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.eq;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherReportServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private WeatherReportService weatherReportService;

    private WeatherApiResponse weatherApiResponse;

    @BeforeEach
    void setUp() {
        // Crear una respuesta simulada para la API
        Main main = new Main();
        main.setTemperature(25.0);
        main.setHumidity(60);

        weatherApiResponse = new WeatherApiResponse();
        weatherApiResponse.setMain(main);
    }

    @Test
    void testGetWeatherReport() {
        // Crear una respuesta simulada de la API
        WeatherApiResponse mockResponse = new WeatherApiResponse();
        Main main = new Main();
        main.setTemperature(25.0);
        mockResponse.setMain(main);

        // Configurar el mock de RestTemplate
        when(restTemplate.getForObject(anyString(), eq(WeatherApiResponse.class)))
                .thenReturn(mockResponse);

        // Llamar al método a probar
        WeatherReport temperature = weatherReportService.getWeatherReport(37.8267, -122.4233);

        // Verificar el resultado
        assertEquals(25.0, temperature);
    }

}
