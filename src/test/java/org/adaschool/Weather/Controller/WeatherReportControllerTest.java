package org.adaschool.Weather.Controller;

import org.adaschool.Weather.controller.WeatherReportController;
import org.adaschool.Weather.data.WeatherReport;
import org.adaschool.Weather.service.WeatherReportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherReportControllerTest {

    @InjectMocks
    private WeatherReportController weatherReportController;

    @Mock
    private WeatherReportService weatherReportService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetWeatherReport() {
        // Datos simulados
        WeatherReport mockReport = new WeatherReport();
        mockReport.setTemperature(25.0);
        mockReport.setHumidity(60);

        // Configurar el mock para devolver el objeto simulado
        Mockito.when(weatherReportService.getWeatherReport(37.8267, -122.4233))
                .thenReturn(mockReport);

        // Ejecutar la llamada al controlador
        WeatherReport result = weatherReportController.getWeatherReport(37.8267, -122.4233);

        // Verificar que los resultados son los esperados
        assertEquals(25.0, result.getTemperature());
        assertEquals(60, result.getHumidity());
    }
}

