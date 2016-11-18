package com.pedronalbert.lolcena.api.models.summoner;

public class SummonerData {

    private Integer id;
    private String name;
    private Integer profileIconId;
    private Integer summonerLevel;
    private Integer revisionDate;
    private String region;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Integer getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(Integer profileIconId) {
        this.profileIconId = profileIconId;
    }


    public Integer getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(Integer summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    public Integer getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(Integer revisionDate) {
        this.revisionDate = revisionDate;
    }


    public String getRegion() {
        return region;
    }


    public void setRegion(String region) {
        this.region = region;
    }

}