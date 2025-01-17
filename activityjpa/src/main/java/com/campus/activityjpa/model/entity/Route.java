/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.activityjpa.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Route {
    
    private Long IdRoute;
    
    private String codeRoute;
    
    private String cityOrigin;
    
    private String cityDestine;
    
    private double distance;
    /*
    @ManyToOne
    @JoinColumn(name = "Id_Airport_Origin", nullable = false)
    private Airport idAirportOrigin;
    
    @ManyToOne
    @JoinColumn(name = "Id_Airport_Destine", nullable = false)
    private Airport idAirportDestine;
    */
    public Route() {
    }

    public Route(Long IdRoute, String codeRoute, String cityOrigin, String cityDestine, double distance) {
        this.IdRoute = IdRoute;
        this.codeRoute = codeRoute;
        this.cityOrigin = cityOrigin;
        this.cityDestine = cityDestine;
        this.distance = distance;
    }

    public Long getIdRoute() {
        return IdRoute;
    }

    public void setIdRoute(Long IdRoute) {
        this.IdRoute = IdRoute;
    }

    public String getCodeRoute() {
        return codeRoute;
    }

    public void setCodeRoute(String codeRoute) {
        this.codeRoute = codeRoute;
    }

    public String getCityOrigin() {
        return cityOrigin;
    }

    public void setCityOrigin(String cityOrigin) {
        this.cityOrigin = cityOrigin;
    }

    public String getCityDestine() {
        return cityDestine;
    }

    public void setCityDestine(String cityDestine) {
        this.cityDestine = cityDestine;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
/*
    public Airport getIdAirportOrigin() {
        return idAirportOrigin;
    }

    public void setIdAirportOrigin(Airport idAirportOrigin) {
        this.idAirportOrigin = idAirportOrigin;
    }

    public Airport getIdAirportDestine() {
        return idAirportDestine;
    }

    public void setIdAirportDestine(Airport idAirportDestine) {
        this.idAirportDestine = idAirportDestine;
    }
    
    
    */

    @Override
    public String toString() {
        return "Route{" + "IdRoute=" + IdRoute + ", codeRoute=" + codeRoute + ", cityOrigin=" + cityOrigin + ", cityDestine=" + cityDestine + ", distance=" + distance + '}';
    }
    
    
    
}
