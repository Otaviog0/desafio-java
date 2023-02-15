package com.example.demo.services;

import com.example.demo.domain.Endereco;
import com.example.demo.domain.Location;
import com.example.demo.domain.ResponseGeoJson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class GeoLocationService {

    @Value("${api.geolocation.key}") private String geolocationKey;

    @CacheEvict(value="enderecos", allEntries=true)
    public Endereco getGeoLocation(String latitude, String longitude) {
        String url = "http://www.mapquestapi.com/geocoding/v1/reverse?" +
                "key="+geolocationKey+"&location="+latitude+","+longitude+"&includeRoadMetadata=true&includeNearestIntersection=true&outFormat";

        WebClient webClient = WebClient.create(url);
        ResponseGeoJson responseJson = webClient.get()
                .exchange()
                .block()
                .bodyToMono(ResponseGeoJson.class)
                .block();

        return ConvertRootToEndereco(responseJson);
    }

    public Endereco ConvertRootToEndereco(ResponseGeoJson responseGeoJson) {
        Endereco endereco = new Endereco();
        if(responseGeoJson.results.get(0).locations.toArray().length > 0) {
            Location location = responseGeoJson.results.get(0).locations.get(0);
                endereco.setLogradouro(location.street);
                endereco.setBairro(location.adminArea5);
                endereco.setCep(location.postalCode);
                endereco.setCidade(location.adminArea5);
                endereco.setEstado(location.adminArea3);
                endereco.setPais(location.adminArea1);
        }
        return endereco;
    }

}
