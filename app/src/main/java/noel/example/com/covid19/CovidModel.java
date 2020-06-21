package noel.example.com.covid19;

public class CovidModel {
    private String flag,country,cases,todayCases,deaths,todayDeaths,recovered,active,critical,casesperonemillion,
    deathsperonemillion,population,tests,testsperonemillion,onecaseperpeople,onedeathperpeople,onetestperpeople,
    activepermillion,recoveredpermillion,criticalpermillion;

    public CovidModel() {
    }

    public CovidModel(String flag, String country, String cases, String todayCases, String deaths, String todayDeaths, String recovered, String active, String critical,
                      String casesperonemillion,String deathsperonemillion,String population,String tests,
                      String testsperonemillion,String onecaseperpeople,String onedeathperpeople,String onetestperpeople,
                      String activepermillion,String recoveredpermillion,String criticalpermillion) {
        this.flag = flag;
        this.country = country;
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.active = active;
        this.critical = critical;
        this.casesperonemillion=casesperonemillion;
        this.deathsperonemillion=deathsperonemillion;
        this.population=population;
        this.tests=tests;
        this.testsperonemillion=testsperonemillion;
        this.onecaseperpeople=onecaseperpeople;
        this.onedeathperpeople=onedeathperpeople;
        this.onetestperpeople=onetestperpeople;
        this.activepermillion=activepermillion;
        this.recoveredpermillion=recoveredpermillion;
        this.criticalpermillion=criticalpermillion;

    }

    public String getCasesperonemillion() {
        return casesperonemillion;
    }

    public void setCasesperonemillion(String casesperonemillion) {
        this.casesperonemillion = casesperonemillion;
    }

    public String getDeathsperonemillion() {
        return deathsperonemillion;
    }

    public void setDeathsperonemillion(String deathsperonemillion) {
        this.deathsperonemillion = deathsperonemillion;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getTests() {
        return tests;
    }

    public void setTests(String tests) {
        this.tests = tests;
    }

    public String getTestsperonemillion() {
        return testsperonemillion;
    }

    public void setTestsperonemillion(String testsperonemillion) {
        this.testsperonemillion = testsperonemillion;
    }

    public String getActivepermillion() {
        return activepermillion;
    }

    public void setActivepermillion(String activepermillion) {
        this.activepermillion = activepermillion;
    }

    public String getRecoveredpermillion() {
        return recoveredpermillion;
    }

    public void setRecoveredpermillion(String recoveredpermillion) {
        this.recoveredpermillion = recoveredpermillion;
    }

    public String getCriticalpermillion() {
        return criticalpermillion;
    }

    public void setCriticalpermillion(String criticalpermillion) {
        this.criticalpermillion = criticalpermillion;
    }

    public String getOnecaseperpeople() {
        return onecaseperpeople;
    }

    public void setOnecaseperpeople(String onecaseperpeople) {
        this.onecaseperpeople = onecaseperpeople;
    }

    public String getOnedeathperpeople() {
        return onedeathperpeople;
    }

    public void setOnedeathperpeople(String onedeathperpeople) {
        this.onedeathperpeople = onedeathperpeople;
    }

    public String getOnetestperpeople() {
        return onetestperpeople;
    }

    public void setOnetestperpeople(String onetestperpeople) {
        this.onetestperpeople = onetestperpeople;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(String todayCases) {
        this.todayCases = todayCases;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(String todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCritical() {
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }
}



