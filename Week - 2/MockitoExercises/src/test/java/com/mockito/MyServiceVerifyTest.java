package com.mockito;


import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceVerifyTest {

    @Test
    public void testVerifyInteraction() {
        // Arrange
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // Act
        service.fetchData();

        // Assert
        verify(mockApi).getData();
    }
}

