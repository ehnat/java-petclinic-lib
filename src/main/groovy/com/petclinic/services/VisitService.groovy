package com.petclinic.services

import com.petclinic.dto.Visit
import groovy.transform.CompileStatic

import static io.restassured.RestAssured.given
import static org.apache.http.HttpStatus.SC_CREATED
import static org.apache.http.HttpStatus.SC_OK

@CompileStatic
class VisitService {

    private final RequestSpecs requestSpecs

    VisitService(RequestSpecs requestSpecs) {
        this.requestSpecs = requestSpecs
    }

     List<Visit> getAllVisits() {
        //@formatter:off
        Arrays.asList(given()
                .spec(requestSpecs.basicSpec())
        .when()
                .get(Paths.VISITS)
        .then()
                .statusCode(SC_OK)
                .extract().as(Visit[].class))
        //@formatter:on
    }

     Visit getVisit(int visitId) {
        //@formatter:off
        given()
                .spec(requestSpecs.basicSpec())
                .pathParam('visitId', visitId)
        .when()
                .get(Paths.VISIT)
        .then()
                .statusCode(SC_OK)
                .extract().response().<Visit>as(Visit)
        //@formatter:on
    }

     Visit addVisit(Visit requestBody) {
        //@formatter:off
        given()
                .spec(requestSpecs.basicSpec())
                .body(requestBody)
        .when()
                .post(Paths.VISITS)
        .then()
                .statusCode(SC_CREATED)
                .extract().response().<Visit>as(Visit)
        //@formatter:on
    }
}
