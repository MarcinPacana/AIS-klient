
package pl.marcin.aisklient.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Generated;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "mmsi",
    "name",
    "imo",
    "ircs",
    "country",
    "shipType",
    "cog",
    "ais",
    "shipRegister",
    "shipRegisterName",
    "aisName",
    "draught",
    "a",
    "b",
    "c",
    "d",
    "isWellBoat"
})
@Generated("jsonschema2pojo")
@Entity
@Table(name = "statki")
public class Vessel {

    @Id
    @JsonProperty("mmsi")
    private Integer mmsi;
    @JsonProperty("name")
    private String name;
    @JsonProperty("imo")
    private Integer imo;
    @JsonProperty("ircs")
    private String ircs;
    @JsonProperty("country")
    private String country;
    @JsonProperty("shipType")
    private Integer shipType;
    @JsonProperty("cog")
    private Double cog;
    @JsonProperty("ais")
    private Boolean ais;
    @JsonProperty("shipRegister")
    private Boolean shipRegister;
    @JsonProperty("shipRegisterName")
    private String shipRegisterName;
    @JsonProperty("aisName")
    private String aisName;
    @JsonProperty("draught")
    private Double draught;
    @JsonProperty("a")
    private Integer a;
    @JsonProperty("b")
    private Integer b;
    @JsonProperty("c")
    private Integer c;
    @JsonProperty("d")
    private Integer d;
    @JsonProperty("isWellBoat")
    private Boolean isWellBoat;

    @ManyToMany(mappedBy = "favoritesVessels",fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<User> usersFavorites = new HashSet<>(0);

    @Transient
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @Transient
    @JsonIgnore
    private String typeName;


    public void setTypeName() {
        if (this.shipType == null){
            this.typeName = ShipType.DEFAULT.getTypeName();
        }else {
            this.typeName = ShipType.getByTypeCode(this.shipType).getTypeName();
        }
    }

    public Vessel(){
        setTypeName();
    }



    @JsonProperty("mmsi")
    public Integer getMmsi() {
        return mmsi;
    }

    @JsonProperty("mmsi")
    public void setMmsi(Integer mmsi) {
        this.mmsi = mmsi;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("imo")
    public Object getImo() {
        return imo;
    }

    @JsonProperty("imo")
    public void setImo(Integer imo) {
        this.imo = imo;
    }

    @JsonProperty("ircs")
    public String getIrcs() {
        return ircs;
    }

    @JsonProperty("ircs")
    public void setIrcs(String ircs) {
        this.ircs = ircs;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("shipType")
    public Integer getShipType() {
        return shipType;
    }

    @JsonProperty("shipType")
    public void setShipType(Integer shipType) {
        this.shipType = shipType;
    }

    @JsonProperty("cog")
    public Double getCog() {
        return cog;
    }

    @JsonProperty("cog")
    public void setCog(Double cog) {
        this.cog = cog;
    }

    @JsonProperty("ais")
    public Boolean getAis() {
        return ais;
    }

    @JsonProperty("ais")
    public void setAis(Boolean ais) {
        this.ais = ais;
    }

    @JsonProperty("shipRegister")
    public Boolean getShipRegister() {
        return shipRegister;
    }

    @JsonProperty("shipRegister")
    public void setShipRegister(Boolean shipRegister) {
        this.shipRegister = shipRegister;
    }

    @JsonProperty("shipRegisterName")
    public String getShipRegisterName() {
        return shipRegisterName;
    }

    @JsonProperty("shipRegisterName")
    public void setShipRegisterName(String shipRegisterName) {
        this.shipRegisterName = shipRegisterName;
    }

    @JsonProperty("aisName")
    public String getAisName() {
        return aisName;
    }

    @JsonProperty("aisName")
    public void setAisName(String aisName) {
        this.aisName = aisName;
    }

    @JsonProperty("draught")
    public Double getDraught() {
        return draught;
    }

    @JsonProperty("draught")
    public void setDraught(Double draught) {
        this.draught = draught;
    }

    @JsonProperty("a")
    public Integer getA() {
        return a;
    }

    @JsonProperty("a")
    public void setA(Integer a) {
        this.a = a;
    }

    @JsonProperty("b")
    public Integer getB() {
        return b;
    }

    @JsonProperty("b")
    public void setB(Integer b) {
        this.b = b;
    }

    @JsonProperty("c")
    public Integer getC() {
        return c;
    }

    @JsonProperty("c")
    public void setC(Integer c) {
        this.c = c;
    }

    @JsonProperty("d")
    public Integer getD() {
        return d;
    }

    @JsonProperty("d")
    public void setD(Integer d) {
        this.d = d;
    }

    @JsonProperty("isWellBoat")
    public Boolean getIsWellBoat() {
        return isWellBoat;
    }

    @JsonProperty("isWellBoat")
    public void setIsWellBoat(Boolean isWellBoat) {
        this.isWellBoat = isWellBoat;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public String getTypeName() {
        return typeName;
    }
}
