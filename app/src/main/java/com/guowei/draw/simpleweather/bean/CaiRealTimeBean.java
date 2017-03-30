package com.guowei.draw.simpleweather.bean;


import java.io.Serializable;
import java.util.List;

public class CaiRealTimeBean implements Serializable{

    /**
     * status : ok
     * lang : zh_CN
     * server_time : 1489455135
     * tzshift : 28800
     * location : [22.576861,113.927135]
     * unit : metric
     * result : {"status":"ok","temperature":20,"skycon":"PARTLY_CLOUDY_DAY","cloudrate":0.55,"aqi":64,"humidity":0.83,"pm25":40,"precipitation":{"nearest":{"status":"ok","distance":24.5,"intensity":0.1875},"local":{"status":"ok","intensity":0,"datasource":"radar"}},"wind":{"direction":44.71,"speed":17.7}}
     */

    private String status;
    private String lang;
    private int server_time;
    private int tzshift;
    private String unit;
    private ResultBean result;
    private List<Double> location;

    @Override
    public String toString() {
        return status+"\n"+server_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public int getServer_time() {
        return server_time;
    }

    public void setServer_time(int server_time) {
        this.server_time = server_time;
    }

    public int getTzshift() {
        return tzshift;
    }

    public void setTzshift(int tzshift) {
        this.tzshift = tzshift;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public List<Double> getLocation() {
        return location;
    }

    public void setLocation(List<Double> location) {
        this.location = location;
    }


    public static class ResultBean {
        /**
         * status : ok
         * temperature : 20
         * skycon : PARTLY_CLOUDY_DAY
         * cloudrate : 0.55
         * aqi : 64
         * humidity : 0.83
         * pm25 : 40
         * precipitation : {"nearest":{"status":"ok","distance":24.5,"intensity":0.1875},"local":{"status":"ok","intensity":0,"datasource":"radar"}}
         * wind : {"direction":44.71,"speed":17.7}
         */

        private String status;
        private float temperature;
        private String skycon;
        private double cloudrate;
        private int aqi;
        private double humidity;
        private int pm25;
        private PrecipitationBean precipitation;
        private WindBean wind;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public float getTemperature() {
            return temperature;
        }

        public void setTemperature(int temperature) {
            this.temperature = temperature;
        }

        public String getSkycon() {
            return skycon;
        }

        public void setSkycon(String skycon) {
            this.skycon = skycon;
        }

        public double getCloudrate() {
            return cloudrate;
        }

        public void setCloudrate(double cloudrate) {
            this.cloudrate = cloudrate;
        }

        public int getAqi() {
            return aqi;
        }

        public void setAqi(int aqi) {
            this.aqi = aqi;
        }

        public double getHumidity() {
            return humidity;
        }

        public void setHumidity(double humidity) {
            this.humidity = humidity;
        }

        public int getPm25() {
            return pm25;
        }

        public void setPm25(int pm25) {
            this.pm25 = pm25;
        }

        public PrecipitationBean getPrecipitation() {
            return precipitation;
        }

        public void setPrecipitation(PrecipitationBean precipitation) {
            this.precipitation = precipitation;
        }

        public WindBean getWind() {
            return wind;
        }

        public void setWind(WindBean wind) {
            this.wind = wind;
        }

        public static class PrecipitationBean {
            /**
             * nearest : {"status":"ok","distance":24.5,"intensity":0.1875}
             * local : {"status":"ok","intensity":0,"datasource":"radar"}
             */

            private NearestBean nearest;
            private LocalBean local;

            public NearestBean getNearest() {
                return nearest;
            }

            public void setNearest(NearestBean nearest) {
                this.nearest = nearest;
            }

            public LocalBean getLocal() {
                return local;
            }

            public void setLocal(LocalBean local) {
                this.local = local;
            }

            public static class NearestBean {
                /**
                 * status : ok
                 * distance : 24.5
                 * intensity : 0.1875
                 */

                private String status;
                private double distance;
                private double intensity;

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public double getDistance() {
                    return distance;
                }

                public void setDistance(double distance) {
                    this.distance = distance;
                }

                public double getIntensity() {
                    return intensity;
                }

                public void setIntensity(double intensity) {
                    this.intensity = intensity;
                }
            }

            public static class LocalBean {
                /**
                 * status : ok
                 * intensity : 0
                 * datasource : radar
                 */

                private String status;
                private double intensity;
                private String datasource;

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public double getIntensity() {
                    return intensity;
                }

                public void setIntensity(double intensity) {
                    this.intensity = intensity;
                }

                public String getDatasource() {
                    return datasource;
                }

                public void setDatasource(String datasource) {
                    this.datasource = datasource;
                }
            }
        }

        public static class WindBean {
            /**
             * direction : 44.71
             * speed : 17.7
             */

            private double direction;
            private double speed;

            public double getDirection() {
                return direction;
            }

            public void setDirection(double direction) {
                this.direction = direction;
            }

            public double getSpeed() {
                return speed;
            }

            public void setSpeed(double speed) {
                this.speed = speed;
            }
        }
    }
}
