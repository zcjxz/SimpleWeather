package com.guowei.draw.simpleweather.bean;

import java.util.List;

public class CaiForecastBean {

    /**
     * status : ok
     * lang : zh_CN
     * result : {"hourly":{"status":"ok","description":"晴，3点钟后多云，转小雨，明天早晨8点钟后雨停","skycon":[{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-13 11:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-13 12:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-13 13:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-13 14:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-13 15:00"},{"value":"CLEAR_DAY","datetime":"2017-03-13 16:00"},{"value":"CLEAR_DAY","datetime":"2017-03-13 17:00"},{"value":"CLEAR_DAY","datetime":"2017-03-13 18:00"},{"value":"CLEAR_NIGHT","datetime":"2017-03-13 19:00"},{"value":"CLEAR_NIGHT","datetime":"2017-03-13 20:00"},{"value":"CLEAR_NIGHT","datetime":"2017-03-13 21:00"},{"value":"CLEAR_NIGHT","datetime":"2017-03-13 22:00"},{"value":"CLEAR_NIGHT","datetime":"2017-03-13 23:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-14 00:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-14 01:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-14 02:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-14 03:00"},{"value":"RAIN","datetime":"2017-03-14 04:00"},{"value":"RAIN","datetime":"2017-03-14 05:00"},{"value":"RAIN","datetime":"2017-03-14 06:00"},{"value":"RAIN","datetime":"2017-03-14 07:00"},{"value":"RAIN","datetime":"2017-03-14 08:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-14 09:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-14 10:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-14 11:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-14 12:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-14 13:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-14 14:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-14 15:00"},{"value":"CLOUDY","datetime":"2017-03-14 16:00"},{"value":"CLOUDY","datetime":"2017-03-14 17:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-14 18:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-14 19:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-14 20:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-14 21:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-14 22:00"},{"value":"CLOUDY","datetime":"2017-03-14 23:00"},{"value":"CLOUDY","datetime":"2017-03-15 00:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-15 01:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-15 02:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-15 03:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-15 04:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-15 05:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-15 06:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-15 07:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-15 08:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-15 09:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-15 10:00"}],"cloudrate":[{"value":0.48,"datetime":"2017-03-13 11:00"},{"value":0.47,"datetime":"2017-03-13 12:00"},{"value":0.43,"datetime":"2017-03-13 13:00"},{"value":0.35,"datetime":"2017-03-13 14:00"},{"value":0.23,"datetime":"2017-03-13 15:00"},{"value":0.1,"datetime":"2017-03-13 16:00"},{"value":0.01,"datetime":"2017-03-13 17:00"},{"value":0,"datetime":"2017-03-13 18:00"},{"value":0,"datetime":"2017-03-13 19:00"},{"value":0.01,"datetime":"2017-03-13 20:00"},{"value":0.05,"datetime":"2017-03-13 21:00"},{"value":0.1,"datetime":"2017-03-13 22:00"},{"value":0.15,"datetime":"2017-03-13 23:00"},{"value":0.21,"datetime":"2017-03-14 00:00"},{"value":0.24,"datetime":"2017-03-14 01:00"},{"value":0.25,"datetime":"2017-03-14 02:00"},{"value":0.22,"datetime":"2017-03-14 03:00"},{"value":0.18,"datetime":"2017-03-14 04:00"},{"value":0.16,"datetime":"2017-03-14 05:00"},{"value":0.19,"datetime":"2017-03-14 06:00"},{"value":0.26,"datetime":"2017-03-14 07:00"},{"value":0.34,"datetime":"2017-03-14 08:00"},{"value":0.41,"datetime":"2017-03-14 09:00"},{"value":0.47,"datetime":"2017-03-14 10:00"},{"value":0.51,"datetime":"2017-03-14 11:00"},{"value":0.52,"datetime":"2017-03-14 12:00"},{"value":0.54,"datetime":"2017-03-14 13:00"},{"value":0.6,"datetime":"2017-03-14 14:00"},{"value":0.7,"datetime":"2017-03-14 15:00"},{"value":0.81,"datetime":"2017-03-14 16:00"},{"value":0.84,"datetime":"2017-03-14 17:00"},{"value":0.76,"datetime":"2017-03-14 18:00"},{"value":0.64,"datetime":"2017-03-14 19:00"},{"value":0.58,"datetime":"2017-03-14 20:00"},{"value":0.64,"datetime":"2017-03-14 21:00"},{"value":0.77,"datetime":"2017-03-14 22:00"},{"value":0.87,"datetime":"2017-03-14 23:00"},{"value":0.87,"datetime":"2017-03-15 00:00"},{"value":0.8,"datetime":"2017-03-15 01:00"},{"value":0.7,"datetime":"2017-03-15 02:00"},{"value":0.61,"datetime":"2017-03-15 03:00"},{"value":0.54,"datetime":"2017-03-15 04:00"},{"value":0.5,"datetime":"2017-03-15 05:00"},{"value":0.49,"datetime":"2017-03-15 06:00"},{"value":0.52,"datetime":"2017-03-15 07:00"},{"value":0.57,"datetime":"2017-03-15 08:00"},{"value":0.65,"datetime":"2017-03-15 09:00"},{"value":0.71,"datetime":"2017-03-15 10:00"}],"aqi":[{"value":52,"datetime":"2017-03-13 11:00"},{"value":49,"datetime":"2017-03-13 12:00"},{"value":46,"datetime":"2017-03-13 13:00"},{"value":43,"datetime":"2017-03-13 14:00"},{"value":42,"datetime":"2017-03-13 15:00"},{"value":39,"datetime":"2017-03-13 16:00"},{"value":38,"datetime":"2017-03-13 17:00"},{"value":38,"datetime":"2017-03-13 18:00"},{"value":38,"datetime":"2017-03-13 19:00"},{"value":38,"datetime":"2017-03-13 20:00"},{"value":39,"datetime":"2017-03-13 21:00"},{"value":41,"datetime":"2017-03-13 22:00"},{"value":42,"datetime":"2017-03-13 23:00"},{"value":42,"datetime":"2017-03-14 00:00"},{"value":42,"datetime":"2017-03-14 01:00"},{"value":42,"datetime":"2017-03-14 02:00"},{"value":41,"datetime":"2017-03-14 03:00"},{"value":41,"datetime":"2017-03-14 04:00"},{"value":38,"datetime":"2017-03-14 05:00"},{"value":37,"datetime":"2017-03-14 06:00"},{"value":34,"datetime":"2017-03-14 07:00"},{"value":31,"datetime":"2017-03-14 08:00"},{"value":30,"datetime":"2017-03-14 09:00"},{"value":30,"datetime":"2017-03-14 10:00"},{"value":29,"datetime":"2017-03-14 11:00"},{"value":27,"datetime":"2017-03-14 12:00"},{"value":26,"datetime":"2017-03-14 13:00"},{"value":26,"datetime":"2017-03-14 14:00"},{"value":29,"datetime":"2017-03-14 15:00"},{"value":33,"datetime":"2017-03-14 16:00"},{"value":38,"datetime":"2017-03-14 17:00"},{"value":41,"datetime":"2017-03-14 18:00"},{"value":45,"datetime":"2017-03-14 19:00"},{"value":47,"datetime":"2017-03-14 20:00"},{"value":49,"datetime":"2017-03-14 21:00"},{"value":50,"datetime":"2017-03-14 22:00"},{"value":52,"datetime":"2017-03-14 23:00"},{"value":53,"datetime":"2017-03-15 00:00"},{"value":53,"datetime":"2017-03-15 01:00"},{"value":55,"datetime":"2017-03-15 02:00"},{"value":53,"datetime":"2017-03-15 03:00"},{"value":53,"datetime":"2017-03-15 04:00"},{"value":53,"datetime":"2017-03-15 05:00"},{"value":52,"datetime":"2017-03-15 06:00"},{"value":52,"datetime":"2017-03-15 07:00"},{"value":52,"datetime":"2017-03-15 08:00"},{"value":53,"datetime":"2017-03-15 09:00"},{"value":55,"datetime":"2017-03-15 10:00"}],"humidity":[{"value":0.72,"datetime":"2017-03-13 11:00"},{"value":0.67,"datetime":"2017-03-13 12:00"},{"value":0.65,"datetime":"2017-03-13 13:00"},{"value":0.64,"datetime":"2017-03-13 14:00"},{"value":0.65,"datetime":"2017-03-13 15:00"},{"value":0.68,"datetime":"2017-03-13 16:00"},{"value":0.73,"datetime":"2017-03-13 17:00"},{"value":0.77,"datetime":"2017-03-13 18:00"},{"value":0.82,"datetime":"2017-03-13 19:00"},{"value":0.86,"datetime":"2017-03-13 20:00"},{"value":0.88,"datetime":"2017-03-13 21:00"},{"value":0.9,"datetime":"2017-03-13 22:00"},{"value":0.91,"datetime":"2017-03-13 23:00"},{"value":0.92,"datetime":"2017-03-14 00:00"},{"value":0.93,"datetime":"2017-03-14 01:00"},{"value":0.93,"datetime":"2017-03-14 02:00"},{"value":0.94,"datetime":"2017-03-14 03:00"},{"value":0.94,"datetime":"2017-03-14 04:00"},{"value":0.93,"datetime":"2017-03-14 05:00"},{"value":0.92,"datetime":"2017-03-14 06:00"},{"value":0.89,"datetime":"2017-03-14 07:00"},{"value":0.84,"datetime":"2017-03-14 08:00"},{"value":0.77,"datetime":"2017-03-14 09:00"},{"value":0.7,"datetime":"2017-03-14 10:00"},{"value":0.66,"datetime":"2017-03-14 11:00"},{"value":0.65,"datetime":"2017-03-14 12:00"},{"value":0.66,"datetime":"2017-03-14 13:00"},{"value":0.68,"datetime":"2017-03-14 14:00"},{"value":0.69,"datetime":"2017-03-14 15:00"},{"value":0.69,"datetime":"2017-03-14 16:00"},{"value":0.7,"datetime":"2017-03-14 17:00"},{"value":0.72,"datetime":"2017-03-14 18:00"},{"value":0.75,"datetime":"2017-03-14 19:00"},{"value":0.77,"datetime":"2017-03-14 20:00"},{"value":0.78,"datetime":"2017-03-14 21:00"},{"value":0.78,"datetime":"2017-03-14 22:00"},{"value":0.78,"datetime":"2017-03-14 23:00"},{"value":0.79,"datetime":"2017-03-15 00:00"},{"value":0.8,"datetime":"2017-03-15 01:00"},{"value":0.8,"datetime":"2017-03-15 02:00"},{"value":0.8,"datetime":"2017-03-15 03:00"},{"value":0.8,"datetime":"2017-03-15 04:00"},{"value":0.8,"datetime":"2017-03-15 05:00"},{"value":0.79,"datetime":"2017-03-15 06:00"},{"value":0.79,"datetime":"2017-03-15 07:00"},{"value":0.77,"datetime":"2017-03-15 08:00"},{"value":0.74,"datetime":"2017-03-15 09:00"},{"value":0.71,"datetime":"2017-03-15 10:00"}],"pm25":[{"value":35,"datetime":"2017-03-13 11:00"},{"value":34,"datetime":"2017-03-13 12:00"},{"value":32,"datetime":"2017-03-13 13:00"},{"value":30,"datetime":"2017-03-13 14:00"},{"value":29,"datetime":"2017-03-13 15:00"},{"value":27,"datetime":"2017-03-13 16:00"},{"value":26,"datetime":"2017-03-13 17:00"},{"value":26,"datetime":"2017-03-13 18:00"},{"value":26,"datetime":"2017-03-13 19:00"},{"value":26,"datetime":"2017-03-13 20:00"},{"value":27,"datetime":"2017-03-13 21:00"},{"value":28,"datetime":"2017-03-13 22:00"},{"value":29,"datetime":"2017-03-13 23:00"},{"value":29,"datetime":"2017-03-14 00:00"},{"value":29,"datetime":"2017-03-14 01:00"},{"value":29,"datetime":"2017-03-14 02:00"},{"value":28,"datetime":"2017-03-14 03:00"},{"value":28,"datetime":"2017-03-14 04:00"},{"value":26,"datetime":"2017-03-14 05:00"},{"value":25,"datetime":"2017-03-14 06:00"},{"value":23,"datetime":"2017-03-14 07:00"},{"value":21,"datetime":"2017-03-14 08:00"},{"value":20,"datetime":"2017-03-14 09:00"},{"value":20,"datetime":"2017-03-14 10:00"},{"value":19,"datetime":"2017-03-14 11:00"},{"value":18,"datetime":"2017-03-14 12:00"},{"value":17,"datetime":"2017-03-14 13:00"},{"value":17,"datetime":"2017-03-14 14:00"},{"value":19,"datetime":"2017-03-14 15:00"},{"value":22,"datetime":"2017-03-14 16:00"},{"value":26,"datetime":"2017-03-14 17:00"},{"value":28,"datetime":"2017-03-14 18:00"},{"value":31,"datetime":"2017-03-14 19:00"},{"value":33,"datetime":"2017-03-14 20:00"},{"value":34,"datetime":"2017-03-14 21:00"},{"value":35,"datetime":"2017-03-14 22:00"},{"value":36,"datetime":"2017-03-14 23:00"},{"value":37,"datetime":"2017-03-15 00:00"},{"value":37,"datetime":"2017-03-15 01:00"},{"value":38,"datetime":"2017-03-15 02:00"},{"value":37,"datetime":"2017-03-15 03:00"},{"value":37,"datetime":"2017-03-15 04:00"},{"value":37,"datetime":"2017-03-15 05:00"},{"value":36,"datetime":"2017-03-15 06:00"},{"value":36,"datetime":"2017-03-15 07:00"},{"value":36,"datetime":"2017-03-15 08:00"},{"value":37,"datetime":"2017-03-15 09:00"},{"value":38,"datetime":"2017-03-15 10:00"}],"precipitation":[{"value":0,"datetime":"2017-03-13 11:00"},{"value":0,"datetime":"2017-03-13 12:00"},{"value":0,"datetime":"2017-03-13 13:00"},{"value":0,"datetime":"2017-03-13 14:00"},{"value":0,"datetime":"2017-03-13 15:00"},{"value":0,"datetime":"2017-03-13 16:00"},{"value":0,"datetime":"2017-03-13 17:00"},{"value":0,"datetime":"2017-03-13 18:00"},{"value":0,"datetime":"2017-03-13 19:00"},{"value":0,"datetime":"2017-03-13 20:00"},{"value":0,"datetime":"2017-03-13 21:00"},{"value":0,"datetime":"2017-03-13 22:00"},{"value":0,"datetime":"2017-03-13 23:00"},{"value":0,"datetime":"2017-03-14 00:00"},{"value":0,"datetime":"2017-03-14 01:00"},{"value":0,"datetime":"2017-03-14 02:00"},{"value":0,"datetime":"2017-03-14 03:00"},{"value":0.0712,"datetime":"2017-03-14 04:00"},{"value":0.0982,"datetime":"2017-03-14 05:00"},{"value":0.1015,"datetime":"2017-03-14 06:00"},{"value":0.0873,"datetime":"2017-03-14 07:00"},{"value":0.0665,"datetime":"2017-03-14 08:00"},{"value":0.0485,"datetime":"2017-03-14 09:00"},{"value":0,"datetime":"2017-03-14 10:00"},{"value":0,"datetime":"2017-03-14 11:00"},{"value":0,"datetime":"2017-03-14 12:00"},{"value":0,"datetime":"2017-03-14 13:00"},{"value":0,"datetime":"2017-03-14 14:00"},{"value":0,"datetime":"2017-03-14 15:00"},{"value":0,"datetime":"2017-03-14 16:00"},{"value":0,"datetime":"2017-03-14 17:00"},{"value":0,"datetime":"2017-03-14 18:00"},{"value":0,"datetime":"2017-03-14 19:00"},{"value":0,"datetime":"2017-03-14 20:00"},{"value":0,"datetime":"2017-03-14 21:00"},{"value":0,"datetime":"2017-03-14 22:00"},{"value":0,"datetime":"2017-03-14 23:00"},{"value":0,"datetime":"2017-03-15 00:00"},{"value":0,"datetime":"2017-03-15 01:00"},{"value":0,"datetime":"2017-03-15 02:00"},{"value":0,"datetime":"2017-03-15 03:00"},{"value":0,"datetime":"2017-03-15 04:00"},{"value":0,"datetime":"2017-03-15 05:00"},{"value":0,"datetime":"2017-03-15 06:00"},{"value":0,"datetime":"2017-03-15 07:00"},{"value":0,"datetime":"2017-03-15 08:00"},{"value":0,"datetime":"2017-03-15 09:00"},{"value":0,"datetime":"2017-03-15 10:00"}],"wind":[{"direction":167.14,"speed":7.19,"datetime":"2017-03-13 11:00"},{"direction":184.24,"speed":9.56,"datetime":"2017-03-13 12:00"},{"direction":191.94,"speed":12.49,"datetime":"2017-03-13 13:00"},{"direction":194.06,"speed":15.04,"datetime":"2017-03-13 14:00"},{"direction":192.68,"speed":16.61,"datetime":"2017-03-13 15:00"},{"direction":189.22,"speed":17.09,"datetime":"2017-03-13 16:00"},{"direction":184.26,"speed":16.48,"datetime":"2017-03-13 17:00"},{"direction":177.72,"speed":14.88,"datetime":"2017-03-13 18:00"},{"direction":169.33,"speed":12.81,"datetime":"2017-03-13 19:00"},{"direction":159.64,"speed":10.8,"datetime":"2017-03-13 20:00"},{"direction":150.51,"speed":9.12,"datetime":"2017-03-13 21:00"},{"direction":142.75,"speed":7.78,"datetime":"2017-03-13 22:00"},{"direction":136.96,"speed":6.82,"datetime":"2017-03-13 23:00"},{"direction":133.38,"speed":6.21,"datetime":"2017-03-14 00:00"},{"direction":128.72,"speed":5.52,"datetime":"2017-03-14 01:00"},{"direction":114.59,"speed":4.42,"datetime":"2017-03-14 02:00"},{"direction":75.15,"speed":3.82,"datetime":"2017-03-14 03:00"},{"direction":40.86,"speed":5.49,"datetime":"2017-03-14 04:00"},{"direction":31.92,"speed":7.69,"datetime":"2017-03-14 05:00"},{"direction":36.3,"speed":9.05,"datetime":"2017-03-14 06:00"},{"direction":46.07,"speed":10.27,"datetime":"2017-03-14 07:00"},{"direction":54.82,"speed":12.26,"datetime":"2017-03-14 08:00"},{"direction":58.74,"speed":15.1,"datetime":"2017-03-14 09:00"},{"direction":59.29,"speed":17.57,"datetime":"2017-03-14 10:00"},{"direction":57.96,"speed":18.26,"datetime":"2017-03-14 11:00"},{"direction":55.1,"speed":16.36,"datetime":"2017-03-14 12:00"},{"direction":52.31,"speed":13.15,"datetime":"2017-03-14 13:00"},{"direction":54.87,"speed":10.33,"datetime":"2017-03-14 14:00"},{"direction":69.23,"speed":9.51,"datetime":"2017-03-14 15:00"},{"direction":84.37,"speed":10.65,"datetime":"2017-03-14 16:00"},{"direction":91.11,"speed":11.77,"datetime":"2017-03-14 17:00"},{"direction":89.76,"speed":11.16,"datetime":"2017-03-14 18:00"},{"direction":83.41,"speed":9.73,"datetime":"2017-03-14 19:00"},{"direction":77.7,"speed":8.96,"datetime":"2017-03-14 20:00"},{"direction":79.89,"speed":9.56,"datetime":"2017-03-14 21:00"},{"direction":84.84,"speed":10.88,"datetime":"2017-03-14 22:00"},{"direction":86.63,"speed":11.8,"datetime":"2017-03-14 23:00"},{"direction":82.76,"speed":11.42,"datetime":"2017-03-15 00:00"},{"direction":74.45,"speed":10.31,"datetime":"2017-03-15 01:00"},{"direction":64.67,"speed":9.24,"datetime":"2017-03-15 02:00"},{"direction":58.51,"speed":8.52,"datetime":"2017-03-15 03:00"},{"direction":57.72,"speed":8.11,"datetime":"2017-03-15 04:00"},{"direction":62.01,"speed":8.18,"datetime":"2017-03-15 05:00"},{"direction":69.15,"speed":8.91,"datetime":"2017-03-15 06:00"},{"direction":76.19,"speed":10.02,"datetime":"2017-03-15 07:00"},{"direction":82.03,"speed":10.99,"datetime":"2017-03-15 08:00"},{"direction":87.23,"speed":11.4,"datetime":"2017-03-15 09:00"},{"direction":93.52,"speed":11.48,"datetime":"2017-03-15 10:00"}],"temperature":[{"value":24,"datetime":"2017-03-13 11:00"},{"value":25.01,"datetime":"2017-03-13 12:00"},{"value":25.69,"datetime":"2017-03-13 13:00"},{"value":25.93,"datetime":"2017-03-13 14:00"},{"value":25.66,"datetime":"2017-03-13 15:00"},{"value":25.01,"datetime":"2017-03-13 16:00"},{"value":24.13,"datetime":"2017-03-13 17:00"},{"value":23.2,"datetime":"2017-03-13 18:00"},{"value":22.34,"datetime":"2017-03-13 19:00"},{"value":21.67,"datetime":"2017-03-13 20:00"},{"value":21.29,"datetime":"2017-03-13 21:00"},{"value":21.1,"datetime":"2017-03-13 22:00"},{"value":21,"datetime":"2017-03-13 23:00"},{"value":20.86,"datetime":"2017-03-14 00:00"},{"value":20.7,"datetime":"2017-03-14 01:00"},{"value":20.53,"datetime":"2017-03-14 02:00"},{"value":20.37,"datetime":"2017-03-14 03:00"},{"value":20.26,"datetime":"2017-03-14 04:00"},{"value":20.27,"datetime":"2017-03-14 05:00"},{"value":20.43,"datetime":"2017-03-14 06:00"},{"value":20.7,"datetime":"2017-03-14 07:00"},{"value":21.06,"datetime":"2017-03-14 08:00"},{"value":21.43,"datetime":"2017-03-14 09:00"},{"value":21.76,"datetime":"2017-03-14 10:00"},{"value":21.96,"datetime":"2017-03-14 11:00"},{"value":21.99,"datetime":"2017-03-14 12:00"},{"value":21.91,"datetime":"2017-03-14 13:00"},{"value":21.79,"datetime":"2017-03-14 14:00"},{"value":21.69,"datetime":"2017-03-14 15:00"},{"value":21.51,"datetime":"2017-03-14 16:00"},{"value":21.15,"datetime":"2017-03-14 17:00"},{"value":20.53,"datetime":"2017-03-14 18:00"},{"value":19.81,"datetime":"2017-03-14 19:00"},{"value":19.18,"datetime":"2017-03-14 20:00"},{"value":18.79,"datetime":"2017-03-14 21:00"},{"value":18.55,"datetime":"2017-03-14 22:00"},{"value":18.3,"datetime":"2017-03-14 23:00"},{"value":17.93,"datetime":"2017-03-15 00:00"},{"value":17.52,"datetime":"2017-03-15 01:00"},{"value":17.16,"datetime":"2017-03-15 02:00"},{"value":16.96,"datetime":"2017-03-15 03:00"},{"value":16.87,"datetime":"2017-03-15 04:00"},{"value":16.83,"datetime":"2017-03-15 05:00"},{"value":16.8,"datetime":"2017-03-15 06:00"},{"value":16.89,"datetime":"2017-03-15 07:00"},{"value":17.23,"datetime":"2017-03-15 08:00"},{"value":17.92,"datetime":"2017-03-15 09:00"},{"value":18.84,"datetime":"2017-03-15 10:00"}]},"minutely":{"status":"ok","description":"未来两小时不会下雨，放心出门吧","probability":[0.0667725578,0.1027696803,0.1439363807,0.1639839709],"datasource":"radar","precipitation_2h":[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],"precipitation":[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]},"daily":{"status":"ok","coldRisk":[{"index":"3","desc":"易发","datetime":"2017-03-13"},{"index":"3","desc":"易发","datetime":"2017-03-14"},{"index":"3","desc":"易发","datetime":"2017-03-15"},{"index":"4","desc":"极易发","datetime":"2017-03-16"},{"index":"3","desc":"易发","datetime":"2017-03-17"}],"temperature":[{"date":"2017-03-13","max":25.93,"avg":23.54,"min":18.99},{"date":"2017-03-14","max":21.99,"avg":20.65,"min":18.3},{"date":"2017-03-15","max":21.68,"avg":18.57,"min":16.8},{"date":"2017-03-16","max":23.72,"avg":19.44,"min":16.36},{"date":"2017-03-17","max":23.51,"avg":20.07,"min":17.22}],"skycon":[{"date":"2017-03-13","value":"CLEAR_DAY"},{"date":"2017-03-14","value":"PARTLY_CLOUDY_DAY"},{"date":"2017-03-15","value":"PARTLY_CLOUDY_DAY"},{"date":"2017-03-16","value":"PARTLY_CLOUDY_DAY"},{"date":"2017-03-17","value":"PARTLY_CLOUDY_DAY"}],"cloudrate":[{"date":"2017-03-13","max":0.9,"avg":0.18,"min":0},{"date":"2017-03-14","max":0.87,"avg":0.49,"min":0.16},{"date":"2017-03-15","max":0.87,"avg":0.68,"min":0.49},{"date":"2017-03-16","max":0.78,"avg":0.38,"min":0.05},{"date":"2017-03-17","max":0.71,"avg":0.36,"min":0}],"aqi":[{"date":"2017-03-13","max":79,"avg":41.92,"min":38},{"date":"2017-03-14","max":52,"avg":37.5,"min":26},{"date":"2017-03-15","max":56,"avg":53.08,"min":50},{"date":"2017-03-16","max":55,"avg":48,"min":39},{"date":"2017-03-17","max":41,"avg":37.67,"min":35}],"humidity":[{"date":"2017-03-13","max":0.95,"avg":0.76,"min":0.64},{"date":"2017-03-14","max":0.94,"avg":0.79,"min":0.65},{"date":"2017-03-15","max":0.8,"avg":0.71,"min":0.6},{"date":"2017-03-16","max":0.82,"avg":0.73,"min":0.6},{"date":"2017-03-17","max":0.87,"avg":0.76,"min":0.63}],"astro":[{"date":"2017-03-13","sunset":{"time":"18:32"},"sunrise":{"time":"06:34"}},{"date":"2017-03-14","sunset":{"time":"18:33"},"sunrise":{"time":"06:33"}},{"date":"2017-03-15","sunset":{"time":"18:33"},"sunrise":{"time":"06:32"}},{"date":"2017-03-16","sunset":{"time":"18:33"},"sunrise":{"time":"06:32"}},{"date":"2017-03-17","sunset":{"time":"18:34"},"sunrise":{"time":"06:31"}}],"ultraviolet":[{"index":"3","desc":"中等","datetime":"2017-03-13"},{"index":"3","desc":"中等","datetime":"2017-03-14"},{"index":"2","desc":"弱","datetime":"2017-03-15"},{"index":"2","desc":"弱","datetime":"2017-03-16"},{"index":"2","desc":"弱","datetime":"2017-03-17"}],"pm25":[{"date":"2017-03-13","max":58,"avg":28.85,"min":26},{"date":"2017-03-14","max":36,"avg":25.54,"min":17},{"date":"2017-03-15","max":39,"avg":36.92,"min":35},{"date":"2017-03-16","max":38,"avg":33.33,"min":27},{"date":"2017-03-17","max":28,"avg":25.75,"min":24}],"dressing":[{"index":"3","desc":"热","datetime":"2017-03-13"},{"index":"4","desc":"温暖","datetime":"2017-03-14"},{"index":"4","desc":"温暖","datetime":"2017-03-15"},{"index":"4","desc":"温暖","datetime":"2017-03-16"},{"index":"4","desc":"温暖","datetime":"2017-03-17"}],"carWashing":[{"index":"1","desc":"适宜","datetime":"2017-03-13"},{"index":"3","desc":"较不适宜","datetime":"2017-03-14"},{"index":"1","desc":"适宜","datetime":"2017-03-15"},{"index":"1","desc":"适宜","datetime":"2017-03-16"},{"index":"1","desc":"适宜","datetime":"2017-03-17"}],"precipitation":[{"date":"2017-03-13","max":0,"avg":0,"min":0},{"date":"2017-03-14","max":0.1015,"avg":0.0197,"min":0},{"date":"2017-03-15","max":0,"avg":0,"min":0},{"date":"2017-03-16","max":0,"avg":0,"min":0},{"date":"2017-03-17","max":0,"avg":0,"min":0}],"wind":[{"date":"2017-03-13","max":{"direction":189.22,"speed":17.09},"avg":{"direction":158.35,"speed":10.59},"min":{"direction":141.91,"speed":6.43}},{"date":"2017-03-14","max":{"direction":57.96,"speed":18.26},"avg":{"direction":68.71,"speed":10.4},"min":{"direction":75.15,"speed":3.82}},{"date":"2017-03-15","max":{"direction":123.42,"speed":16.3},"avg":{"direction":102.97,"speed":12.48},"min":{"direction":57.72,"speed":8.11}},{"date":"2017-03-16","max":{"direction":129.87,"speed":14.86},"avg":{"direction":114.64,"speed":11.32},"min":{"direction":87.19,"speed":8.23}},{"date":"2017-03-17","max":{"direction":136.23,"speed":17.48},"avg":{"direction":113.5,"speed":13.13},"min":{"direction":93.33,"speed":9.24}}]},"primary":0}
     * server_time : 1489375300
     * api_status : active
     * tzshift : 28800
     * api_version : v2.2
     * unit : metric
     * location : [22.576861,113.927135]
     */

    private String status;
    private String lang;
    private ResultBean result;
    private int server_time;
    private String api_status;
    private int tzshift;
    private String api_version;
    private String unit;
    private List<Double> location;

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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getServer_time() {
        return server_time;
    }

    public void setServer_time(int server_time) {
        this.server_time = server_time;
    }

    public String getApi_status() {
        return api_status;
    }

    public void setApi_status(String api_status) {
        this.api_status = api_status;
    }

    public int getTzshift() {
        return tzshift;
    }

    public void setTzshift(int tzshift) {
        this.tzshift = tzshift;
    }

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<Double> getLocation() {
        return location;
    }

    public void setLocation(List<Double> location) {
        this.location = location;
    }

    public static class ResultBean {
        /**
         * hourly : {"status":"ok","description":"晴，3点钟后多云，转小雨，明天早晨8点钟后雨停","skycon":[{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-13 11:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-13 12:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-13 13:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-13 14:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-13 15:00"},{"value":"CLEAR_DAY","datetime":"2017-03-13 16:00"},{"value":"CLEAR_DAY","datetime":"2017-03-13 17:00"},{"value":"CLEAR_DAY","datetime":"2017-03-13 18:00"},{"value":"CLEAR_NIGHT","datetime":"2017-03-13 19:00"},{"value":"CLEAR_NIGHT","datetime":"2017-03-13 20:00"},{"value":"CLEAR_NIGHT","datetime":"2017-03-13 21:00"},{"value":"CLEAR_NIGHT","datetime":"2017-03-13 22:00"},{"value":"CLEAR_NIGHT","datetime":"2017-03-13 23:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-14 00:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-14 01:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-14 02:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-14 03:00"},{"value":"RAIN","datetime":"2017-03-14 04:00"},{"value":"RAIN","datetime":"2017-03-14 05:00"},{"value":"RAIN","datetime":"2017-03-14 06:00"},{"value":"RAIN","datetime":"2017-03-14 07:00"},{"value":"RAIN","datetime":"2017-03-14 08:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-14 09:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-14 10:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-14 11:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-14 12:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-14 13:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-14 14:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-14 15:00"},{"value":"CLOUDY","datetime":"2017-03-14 16:00"},{"value":"CLOUDY","datetime":"2017-03-14 17:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-14 18:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-14 19:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-14 20:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-14 21:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-14 22:00"},{"value":"CLOUDY","datetime":"2017-03-14 23:00"},{"value":"CLOUDY","datetime":"2017-03-15 00:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-15 01:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-15 02:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-15 03:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-15 04:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-15 05:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-15 06:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-15 07:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-15 08:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-15 09:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-15 10:00"}],"cloudrate":[{"value":0.48,"datetime":"2017-03-13 11:00"},{"value":0.47,"datetime":"2017-03-13 12:00"},{"value":0.43,"datetime":"2017-03-13 13:00"},{"value":0.35,"datetime":"2017-03-13 14:00"},{"value":0.23,"datetime":"2017-03-13 15:00"},{"value":0.1,"datetime":"2017-03-13 16:00"},{"value":0.01,"datetime":"2017-03-13 17:00"},{"value":0,"datetime":"2017-03-13 18:00"},{"value":0,"datetime":"2017-03-13 19:00"},{"value":0.01,"datetime":"2017-03-13 20:00"},{"value":0.05,"datetime":"2017-03-13 21:00"},{"value":0.1,"datetime":"2017-03-13 22:00"},{"value":0.15,"datetime":"2017-03-13 23:00"},{"value":0.21,"datetime":"2017-03-14 00:00"},{"value":0.24,"datetime":"2017-03-14 01:00"},{"value":0.25,"datetime":"2017-03-14 02:00"},{"value":0.22,"datetime":"2017-03-14 03:00"},{"value":0.18,"datetime":"2017-03-14 04:00"},{"value":0.16,"datetime":"2017-03-14 05:00"},{"value":0.19,"datetime":"2017-03-14 06:00"},{"value":0.26,"datetime":"2017-03-14 07:00"},{"value":0.34,"datetime":"2017-03-14 08:00"},{"value":0.41,"datetime":"2017-03-14 09:00"},{"value":0.47,"datetime":"2017-03-14 10:00"},{"value":0.51,"datetime":"2017-03-14 11:00"},{"value":0.52,"datetime":"2017-03-14 12:00"},{"value":0.54,"datetime":"2017-03-14 13:00"},{"value":0.6,"datetime":"2017-03-14 14:00"},{"value":0.7,"datetime":"2017-03-14 15:00"},{"value":0.81,"datetime":"2017-03-14 16:00"},{"value":0.84,"datetime":"2017-03-14 17:00"},{"value":0.76,"datetime":"2017-03-14 18:00"},{"value":0.64,"datetime":"2017-03-14 19:00"},{"value":0.58,"datetime":"2017-03-14 20:00"},{"value":0.64,"datetime":"2017-03-14 21:00"},{"value":0.77,"datetime":"2017-03-14 22:00"},{"value":0.87,"datetime":"2017-03-14 23:00"},{"value":0.87,"datetime":"2017-03-15 00:00"},{"value":0.8,"datetime":"2017-03-15 01:00"},{"value":0.7,"datetime":"2017-03-15 02:00"},{"value":0.61,"datetime":"2017-03-15 03:00"},{"value":0.54,"datetime":"2017-03-15 04:00"},{"value":0.5,"datetime":"2017-03-15 05:00"},{"value":0.49,"datetime":"2017-03-15 06:00"},{"value":0.52,"datetime":"2017-03-15 07:00"},{"value":0.57,"datetime":"2017-03-15 08:00"},{"value":0.65,"datetime":"2017-03-15 09:00"},{"value":0.71,"datetime":"2017-03-15 10:00"}],"aqi":[{"value":52,"datetime":"2017-03-13 11:00"},{"value":49,"datetime":"2017-03-13 12:00"},{"value":46,"datetime":"2017-03-13 13:00"},{"value":43,"datetime":"2017-03-13 14:00"},{"value":42,"datetime":"2017-03-13 15:00"},{"value":39,"datetime":"2017-03-13 16:00"},{"value":38,"datetime":"2017-03-13 17:00"},{"value":38,"datetime":"2017-03-13 18:00"},{"value":38,"datetime":"2017-03-13 19:00"},{"value":38,"datetime":"2017-03-13 20:00"},{"value":39,"datetime":"2017-03-13 21:00"},{"value":41,"datetime":"2017-03-13 22:00"},{"value":42,"datetime":"2017-03-13 23:00"},{"value":42,"datetime":"2017-03-14 00:00"},{"value":42,"datetime":"2017-03-14 01:00"},{"value":42,"datetime":"2017-03-14 02:00"},{"value":41,"datetime":"2017-03-14 03:00"},{"value":41,"datetime":"2017-03-14 04:00"},{"value":38,"datetime":"2017-03-14 05:00"},{"value":37,"datetime":"2017-03-14 06:00"},{"value":34,"datetime":"2017-03-14 07:00"},{"value":31,"datetime":"2017-03-14 08:00"},{"value":30,"datetime":"2017-03-14 09:00"},{"value":30,"datetime":"2017-03-14 10:00"},{"value":29,"datetime":"2017-03-14 11:00"},{"value":27,"datetime":"2017-03-14 12:00"},{"value":26,"datetime":"2017-03-14 13:00"},{"value":26,"datetime":"2017-03-14 14:00"},{"value":29,"datetime":"2017-03-14 15:00"},{"value":33,"datetime":"2017-03-14 16:00"},{"value":38,"datetime":"2017-03-14 17:00"},{"value":41,"datetime":"2017-03-14 18:00"},{"value":45,"datetime":"2017-03-14 19:00"},{"value":47,"datetime":"2017-03-14 20:00"},{"value":49,"datetime":"2017-03-14 21:00"},{"value":50,"datetime":"2017-03-14 22:00"},{"value":52,"datetime":"2017-03-14 23:00"},{"value":53,"datetime":"2017-03-15 00:00"},{"value":53,"datetime":"2017-03-15 01:00"},{"value":55,"datetime":"2017-03-15 02:00"},{"value":53,"datetime":"2017-03-15 03:00"},{"value":53,"datetime":"2017-03-15 04:00"},{"value":53,"datetime":"2017-03-15 05:00"},{"value":52,"datetime":"2017-03-15 06:00"},{"value":52,"datetime":"2017-03-15 07:00"},{"value":52,"datetime":"2017-03-15 08:00"},{"value":53,"datetime":"2017-03-15 09:00"},{"value":55,"datetime":"2017-03-15 10:00"}],"humidity":[{"value":0.72,"datetime":"2017-03-13 11:00"},{"value":0.67,"datetime":"2017-03-13 12:00"},{"value":0.65,"datetime":"2017-03-13 13:00"},{"value":0.64,"datetime":"2017-03-13 14:00"},{"value":0.65,"datetime":"2017-03-13 15:00"},{"value":0.68,"datetime":"2017-03-13 16:00"},{"value":0.73,"datetime":"2017-03-13 17:00"},{"value":0.77,"datetime":"2017-03-13 18:00"},{"value":0.82,"datetime":"2017-03-13 19:00"},{"value":0.86,"datetime":"2017-03-13 20:00"},{"value":0.88,"datetime":"2017-03-13 21:00"},{"value":0.9,"datetime":"2017-03-13 22:00"},{"value":0.91,"datetime":"2017-03-13 23:00"},{"value":0.92,"datetime":"2017-03-14 00:00"},{"value":0.93,"datetime":"2017-03-14 01:00"},{"value":0.93,"datetime":"2017-03-14 02:00"},{"value":0.94,"datetime":"2017-03-14 03:00"},{"value":0.94,"datetime":"2017-03-14 04:00"},{"value":0.93,"datetime":"2017-03-14 05:00"},{"value":0.92,"datetime":"2017-03-14 06:00"},{"value":0.89,"datetime":"2017-03-14 07:00"},{"value":0.84,"datetime":"2017-03-14 08:00"},{"value":0.77,"datetime":"2017-03-14 09:00"},{"value":0.7,"datetime":"2017-03-14 10:00"},{"value":0.66,"datetime":"2017-03-14 11:00"},{"value":0.65,"datetime":"2017-03-14 12:00"},{"value":0.66,"datetime":"2017-03-14 13:00"},{"value":0.68,"datetime":"2017-03-14 14:00"},{"value":0.69,"datetime":"2017-03-14 15:00"},{"value":0.69,"datetime":"2017-03-14 16:00"},{"value":0.7,"datetime":"2017-03-14 17:00"},{"value":0.72,"datetime":"2017-03-14 18:00"},{"value":0.75,"datetime":"2017-03-14 19:00"},{"value":0.77,"datetime":"2017-03-14 20:00"},{"value":0.78,"datetime":"2017-03-14 21:00"},{"value":0.78,"datetime":"2017-03-14 22:00"},{"value":0.78,"datetime":"2017-03-14 23:00"},{"value":0.79,"datetime":"2017-03-15 00:00"},{"value":0.8,"datetime":"2017-03-15 01:00"},{"value":0.8,"datetime":"2017-03-15 02:00"},{"value":0.8,"datetime":"2017-03-15 03:00"},{"value":0.8,"datetime":"2017-03-15 04:00"},{"value":0.8,"datetime":"2017-03-15 05:00"},{"value":0.79,"datetime":"2017-03-15 06:00"},{"value":0.79,"datetime":"2017-03-15 07:00"},{"value":0.77,"datetime":"2017-03-15 08:00"},{"value":0.74,"datetime":"2017-03-15 09:00"},{"value":0.71,"datetime":"2017-03-15 10:00"}],"pm25":[{"value":35,"datetime":"2017-03-13 11:00"},{"value":34,"datetime":"2017-03-13 12:00"},{"value":32,"datetime":"2017-03-13 13:00"},{"value":30,"datetime":"2017-03-13 14:00"},{"value":29,"datetime":"2017-03-13 15:00"},{"value":27,"datetime":"2017-03-13 16:00"},{"value":26,"datetime":"2017-03-13 17:00"},{"value":26,"datetime":"2017-03-13 18:00"},{"value":26,"datetime":"2017-03-13 19:00"},{"value":26,"datetime":"2017-03-13 20:00"},{"value":27,"datetime":"2017-03-13 21:00"},{"value":28,"datetime":"2017-03-13 22:00"},{"value":29,"datetime":"2017-03-13 23:00"},{"value":29,"datetime":"2017-03-14 00:00"},{"value":29,"datetime":"2017-03-14 01:00"},{"value":29,"datetime":"2017-03-14 02:00"},{"value":28,"datetime":"2017-03-14 03:00"},{"value":28,"datetime":"2017-03-14 04:00"},{"value":26,"datetime":"2017-03-14 05:00"},{"value":25,"datetime":"2017-03-14 06:00"},{"value":23,"datetime":"2017-03-14 07:00"},{"value":21,"datetime":"2017-03-14 08:00"},{"value":20,"datetime":"2017-03-14 09:00"},{"value":20,"datetime":"2017-03-14 10:00"},{"value":19,"datetime":"2017-03-14 11:00"},{"value":18,"datetime":"2017-03-14 12:00"},{"value":17,"datetime":"2017-03-14 13:00"},{"value":17,"datetime":"2017-03-14 14:00"},{"value":19,"datetime":"2017-03-14 15:00"},{"value":22,"datetime":"2017-03-14 16:00"},{"value":26,"datetime":"2017-03-14 17:00"},{"value":28,"datetime":"2017-03-14 18:00"},{"value":31,"datetime":"2017-03-14 19:00"},{"value":33,"datetime":"2017-03-14 20:00"},{"value":34,"datetime":"2017-03-14 21:00"},{"value":35,"datetime":"2017-03-14 22:00"},{"value":36,"datetime":"2017-03-14 23:00"},{"value":37,"datetime":"2017-03-15 00:00"},{"value":37,"datetime":"2017-03-15 01:00"},{"value":38,"datetime":"2017-03-15 02:00"},{"value":37,"datetime":"2017-03-15 03:00"},{"value":37,"datetime":"2017-03-15 04:00"},{"value":37,"datetime":"2017-03-15 05:00"},{"value":36,"datetime":"2017-03-15 06:00"},{"value":36,"datetime":"2017-03-15 07:00"},{"value":36,"datetime":"2017-03-15 08:00"},{"value":37,"datetime":"2017-03-15 09:00"},{"value":38,"datetime":"2017-03-15 10:00"}],"precipitation":[{"value":0,"datetime":"2017-03-13 11:00"},{"value":0,"datetime":"2017-03-13 12:00"},{"value":0,"datetime":"2017-03-13 13:00"},{"value":0,"datetime":"2017-03-13 14:00"},{"value":0,"datetime":"2017-03-13 15:00"},{"value":0,"datetime":"2017-03-13 16:00"},{"value":0,"datetime":"2017-03-13 17:00"},{"value":0,"datetime":"2017-03-13 18:00"},{"value":0,"datetime":"2017-03-13 19:00"},{"value":0,"datetime":"2017-03-13 20:00"},{"value":0,"datetime":"2017-03-13 21:00"},{"value":0,"datetime":"2017-03-13 22:00"},{"value":0,"datetime":"2017-03-13 23:00"},{"value":0,"datetime":"2017-03-14 00:00"},{"value":0,"datetime":"2017-03-14 01:00"},{"value":0,"datetime":"2017-03-14 02:00"},{"value":0,"datetime":"2017-03-14 03:00"},{"value":0.0712,"datetime":"2017-03-14 04:00"},{"value":0.0982,"datetime":"2017-03-14 05:00"},{"value":0.1015,"datetime":"2017-03-14 06:00"},{"value":0.0873,"datetime":"2017-03-14 07:00"},{"value":0.0665,"datetime":"2017-03-14 08:00"},{"value":0.0485,"datetime":"2017-03-14 09:00"},{"value":0,"datetime":"2017-03-14 10:00"},{"value":0,"datetime":"2017-03-14 11:00"},{"value":0,"datetime":"2017-03-14 12:00"},{"value":0,"datetime":"2017-03-14 13:00"},{"value":0,"datetime":"2017-03-14 14:00"},{"value":0,"datetime":"2017-03-14 15:00"},{"value":0,"datetime":"2017-03-14 16:00"},{"value":0,"datetime":"2017-03-14 17:00"},{"value":0,"datetime":"2017-03-14 18:00"},{"value":0,"datetime":"2017-03-14 19:00"},{"value":0,"datetime":"2017-03-14 20:00"},{"value":0,"datetime":"2017-03-14 21:00"},{"value":0,"datetime":"2017-03-14 22:00"},{"value":0,"datetime":"2017-03-14 23:00"},{"value":0,"datetime":"2017-03-15 00:00"},{"value":0,"datetime":"2017-03-15 01:00"},{"value":0,"datetime":"2017-03-15 02:00"},{"value":0,"datetime":"2017-03-15 03:00"},{"value":0,"datetime":"2017-03-15 04:00"},{"value":0,"datetime":"2017-03-15 05:00"},{"value":0,"datetime":"2017-03-15 06:00"},{"value":0,"datetime":"2017-03-15 07:00"},{"value":0,"datetime":"2017-03-15 08:00"},{"value":0,"datetime":"2017-03-15 09:00"},{"value":0,"datetime":"2017-03-15 10:00"}],"wind":[{"direction":167.14,"speed":7.19,"datetime":"2017-03-13 11:00"},{"direction":184.24,"speed":9.56,"datetime":"2017-03-13 12:00"},{"direction":191.94,"speed":12.49,"datetime":"2017-03-13 13:00"},{"direction":194.06,"speed":15.04,"datetime":"2017-03-13 14:00"},{"direction":192.68,"speed":16.61,"datetime":"2017-03-13 15:00"},{"direction":189.22,"speed":17.09,"datetime":"2017-03-13 16:00"},{"direction":184.26,"speed":16.48,"datetime":"2017-03-13 17:00"},{"direction":177.72,"speed":14.88,"datetime":"2017-03-13 18:00"},{"direction":169.33,"speed":12.81,"datetime":"2017-03-13 19:00"},{"direction":159.64,"speed":10.8,"datetime":"2017-03-13 20:00"},{"direction":150.51,"speed":9.12,"datetime":"2017-03-13 21:00"},{"direction":142.75,"speed":7.78,"datetime":"2017-03-13 22:00"},{"direction":136.96,"speed":6.82,"datetime":"2017-03-13 23:00"},{"direction":133.38,"speed":6.21,"datetime":"2017-03-14 00:00"},{"direction":128.72,"speed":5.52,"datetime":"2017-03-14 01:00"},{"direction":114.59,"speed":4.42,"datetime":"2017-03-14 02:00"},{"direction":75.15,"speed":3.82,"datetime":"2017-03-14 03:00"},{"direction":40.86,"speed":5.49,"datetime":"2017-03-14 04:00"},{"direction":31.92,"speed":7.69,"datetime":"2017-03-14 05:00"},{"direction":36.3,"speed":9.05,"datetime":"2017-03-14 06:00"},{"direction":46.07,"speed":10.27,"datetime":"2017-03-14 07:00"},{"direction":54.82,"speed":12.26,"datetime":"2017-03-14 08:00"},{"direction":58.74,"speed":15.1,"datetime":"2017-03-14 09:00"},{"direction":59.29,"speed":17.57,"datetime":"2017-03-14 10:00"},{"direction":57.96,"speed":18.26,"datetime":"2017-03-14 11:00"},{"direction":55.1,"speed":16.36,"datetime":"2017-03-14 12:00"},{"direction":52.31,"speed":13.15,"datetime":"2017-03-14 13:00"},{"direction":54.87,"speed":10.33,"datetime":"2017-03-14 14:00"},{"direction":69.23,"speed":9.51,"datetime":"2017-03-14 15:00"},{"direction":84.37,"speed":10.65,"datetime":"2017-03-14 16:00"},{"direction":91.11,"speed":11.77,"datetime":"2017-03-14 17:00"},{"direction":89.76,"speed":11.16,"datetime":"2017-03-14 18:00"},{"direction":83.41,"speed":9.73,"datetime":"2017-03-14 19:00"},{"direction":77.7,"speed":8.96,"datetime":"2017-03-14 20:00"},{"direction":79.89,"speed":9.56,"datetime":"2017-03-14 21:00"},{"direction":84.84,"speed":10.88,"datetime":"2017-03-14 22:00"},{"direction":86.63,"speed":11.8,"datetime":"2017-03-14 23:00"},{"direction":82.76,"speed":11.42,"datetime":"2017-03-15 00:00"},{"direction":74.45,"speed":10.31,"datetime":"2017-03-15 01:00"},{"direction":64.67,"speed":9.24,"datetime":"2017-03-15 02:00"},{"direction":58.51,"speed":8.52,"datetime":"2017-03-15 03:00"},{"direction":57.72,"speed":8.11,"datetime":"2017-03-15 04:00"},{"direction":62.01,"speed":8.18,"datetime":"2017-03-15 05:00"},{"direction":69.15,"speed":8.91,"datetime":"2017-03-15 06:00"},{"direction":76.19,"speed":10.02,"datetime":"2017-03-15 07:00"},{"direction":82.03,"speed":10.99,"datetime":"2017-03-15 08:00"},{"direction":87.23,"speed":11.4,"datetime":"2017-03-15 09:00"},{"direction":93.52,"speed":11.48,"datetime":"2017-03-15 10:00"}],"temperature":[{"value":24,"datetime":"2017-03-13 11:00"},{"value":25.01,"datetime":"2017-03-13 12:00"},{"value":25.69,"datetime":"2017-03-13 13:00"},{"value":25.93,"datetime":"2017-03-13 14:00"},{"value":25.66,"datetime":"2017-03-13 15:00"},{"value":25.01,"datetime":"2017-03-13 16:00"},{"value":24.13,"datetime":"2017-03-13 17:00"},{"value":23.2,"datetime":"2017-03-13 18:00"},{"value":22.34,"datetime":"2017-03-13 19:00"},{"value":21.67,"datetime":"2017-03-13 20:00"},{"value":21.29,"datetime":"2017-03-13 21:00"},{"value":21.1,"datetime":"2017-03-13 22:00"},{"value":21,"datetime":"2017-03-13 23:00"},{"value":20.86,"datetime":"2017-03-14 00:00"},{"value":20.7,"datetime":"2017-03-14 01:00"},{"value":20.53,"datetime":"2017-03-14 02:00"},{"value":20.37,"datetime":"2017-03-14 03:00"},{"value":20.26,"datetime":"2017-03-14 04:00"},{"value":20.27,"datetime":"2017-03-14 05:00"},{"value":20.43,"datetime":"2017-03-14 06:00"},{"value":20.7,"datetime":"2017-03-14 07:00"},{"value":21.06,"datetime":"2017-03-14 08:00"},{"value":21.43,"datetime":"2017-03-14 09:00"},{"value":21.76,"datetime":"2017-03-14 10:00"},{"value":21.96,"datetime":"2017-03-14 11:00"},{"value":21.99,"datetime":"2017-03-14 12:00"},{"value":21.91,"datetime":"2017-03-14 13:00"},{"value":21.79,"datetime":"2017-03-14 14:00"},{"value":21.69,"datetime":"2017-03-14 15:00"},{"value":21.51,"datetime":"2017-03-14 16:00"},{"value":21.15,"datetime":"2017-03-14 17:00"},{"value":20.53,"datetime":"2017-03-14 18:00"},{"value":19.81,"datetime":"2017-03-14 19:00"},{"value":19.18,"datetime":"2017-03-14 20:00"},{"value":18.79,"datetime":"2017-03-14 21:00"},{"value":18.55,"datetime":"2017-03-14 22:00"},{"value":18.3,"datetime":"2017-03-14 23:00"},{"value":17.93,"datetime":"2017-03-15 00:00"},{"value":17.52,"datetime":"2017-03-15 01:00"},{"value":17.16,"datetime":"2017-03-15 02:00"},{"value":16.96,"datetime":"2017-03-15 03:00"},{"value":16.87,"datetime":"2017-03-15 04:00"},{"value":16.83,"datetime":"2017-03-15 05:00"},{"value":16.8,"datetime":"2017-03-15 06:00"},{"value":16.89,"datetime":"2017-03-15 07:00"},{"value":17.23,"datetime":"2017-03-15 08:00"},{"value":17.92,"datetime":"2017-03-15 09:00"},{"value":18.84,"datetime":"2017-03-15 10:00"}]}
         * minutely : {"status":"ok","description":"未来两小时不会下雨，放心出门吧","probability":[0.0667725578,0.1027696803,0.1439363807,0.1639839709],"datasource":"radar","precipitation_2h":[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],"precipitation":[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]}
         * daily : {"status":"ok","coldRisk":[{"index":"3","desc":"易发","datetime":"2017-03-13"},{"index":"3","desc":"易发","datetime":"2017-03-14"},{"index":"3","desc":"易发","datetime":"2017-03-15"},{"index":"4","desc":"极易发","datetime":"2017-03-16"},{"index":"3","desc":"易发","datetime":"2017-03-17"}],"temperature":[{"date":"2017-03-13","max":25.93,"avg":23.54,"min":18.99},{"date":"2017-03-14","max":21.99,"avg":20.65,"min":18.3},{"date":"2017-03-15","max":21.68,"avg":18.57,"min":16.8},{"date":"2017-03-16","max":23.72,"avg":19.44,"min":16.36},{"date":"2017-03-17","max":23.51,"avg":20.07,"min":17.22}],"skycon":[{"date":"2017-03-13","value":"CLEAR_DAY"},{"date":"2017-03-14","value":"PARTLY_CLOUDY_DAY"},{"date":"2017-03-15","value":"PARTLY_CLOUDY_DAY"},{"date":"2017-03-16","value":"PARTLY_CLOUDY_DAY"},{"date":"2017-03-17","value":"PARTLY_CLOUDY_DAY"}],"cloudrate":[{"date":"2017-03-13","max":0.9,"avg":0.18,"min":0},{"date":"2017-03-14","max":0.87,"avg":0.49,"min":0.16},{"date":"2017-03-15","max":0.87,"avg":0.68,"min":0.49},{"date":"2017-03-16","max":0.78,"avg":0.38,"min":0.05},{"date":"2017-03-17","max":0.71,"avg":0.36,"min":0}],"aqi":[{"date":"2017-03-13","max":79,"avg":41.92,"min":38},{"date":"2017-03-14","max":52,"avg":37.5,"min":26},{"date":"2017-03-15","max":56,"avg":53.08,"min":50},{"date":"2017-03-16","max":55,"avg":48,"min":39},{"date":"2017-03-17","max":41,"avg":37.67,"min":35}],"humidity":[{"date":"2017-03-13","max":0.95,"avg":0.76,"min":0.64},{"date":"2017-03-14","max":0.94,"avg":0.79,"min":0.65},{"date":"2017-03-15","max":0.8,"avg":0.71,"min":0.6},{"date":"2017-03-16","max":0.82,"avg":0.73,"min":0.6},{"date":"2017-03-17","max":0.87,"avg":0.76,"min":0.63}],"astro":[{"date":"2017-03-13","sunset":{"time":"18:32"},"sunrise":{"time":"06:34"}},{"date":"2017-03-14","sunset":{"time":"18:33"},"sunrise":{"time":"06:33"}},{"date":"2017-03-15","sunset":{"time":"18:33"},"sunrise":{"time":"06:32"}},{"date":"2017-03-16","sunset":{"time":"18:33"},"sunrise":{"time":"06:32"}},{"date":"2017-03-17","sunset":{"time":"18:34"},"sunrise":{"time":"06:31"}}],"ultraviolet":[{"index":"3","desc":"中等","datetime":"2017-03-13"},{"index":"3","desc":"中等","datetime":"2017-03-14"},{"index":"2","desc":"弱","datetime":"2017-03-15"},{"index":"2","desc":"弱","datetime":"2017-03-16"},{"index":"2","desc":"弱","datetime":"2017-03-17"}],"pm25":[{"date":"2017-03-13","max":58,"avg":28.85,"min":26},{"date":"2017-03-14","max":36,"avg":25.54,"min":17},{"date":"2017-03-15","max":39,"avg":36.92,"min":35},{"date":"2017-03-16","max":38,"avg":33.33,"min":27},{"date":"2017-03-17","max":28,"avg":25.75,"min":24}],"dressing":[{"index":"3","desc":"热","datetime":"2017-03-13"},{"index":"4","desc":"温暖","datetime":"2017-03-14"},{"index":"4","desc":"温暖","datetime":"2017-03-15"},{"index":"4","desc":"温暖","datetime":"2017-03-16"},{"index":"4","desc":"温暖","datetime":"2017-03-17"}],"carWashing":[{"index":"1","desc":"适宜","datetime":"2017-03-13"},{"index":"3","desc":"较不适宜","datetime":"2017-03-14"},{"index":"1","desc":"适宜","datetime":"2017-03-15"},{"index":"1","desc":"适宜","datetime":"2017-03-16"},{"index":"1","desc":"适宜","datetime":"2017-03-17"}],"precipitation":[{"date":"2017-03-13","max":0,"avg":0,"min":0},{"date":"2017-03-14","max":0.1015,"avg":0.0197,"min":0},{"date":"2017-03-15","max":0,"avg":0,"min":0},{"date":"2017-03-16","max":0,"avg":0,"min":0},{"date":"2017-03-17","max":0,"avg":0,"min":0}],"wind":[{"date":"2017-03-13","max":{"direction":189.22,"speed":17.09},"avg":{"direction":158.35,"speed":10.59},"min":{"direction":141.91,"speed":6.43}},{"date":"2017-03-14","max":{"direction":57.96,"speed":18.26},"avg":{"direction":68.71,"speed":10.4},"min":{"direction":75.15,"speed":3.82}},{"date":"2017-03-15","max":{"direction":123.42,"speed":16.3},"avg":{"direction":102.97,"speed":12.48},"min":{"direction":57.72,"speed":8.11}},{"date":"2017-03-16","max":{"direction":129.87,"speed":14.86},"avg":{"direction":114.64,"speed":11.32},"min":{"direction":87.19,"speed":8.23}},{"date":"2017-03-17","max":{"direction":136.23,"speed":17.48},"avg":{"direction":113.5,"speed":13.13},"min":{"direction":93.33,"speed":9.24}}]}
         * primary : 0
         */

        private HourlyBean hourly;
        private MinutelyBean minutely;
        private DailyBean daily;
        private int primary;

        public HourlyBean getHourly() {
            return hourly;
        }

        public void setHourly(HourlyBean hourly) {
            this.hourly = hourly;
        }

        public MinutelyBean getMinutely() {
            return minutely;
        }

        public void setMinutely(MinutelyBean minutely) {
            this.minutely = minutely;
        }

        public DailyBean getDaily() {
            return daily;
        }

        public void setDaily(DailyBean daily) {
            this.daily = daily;
        }

        public int getPrimary() {
            return primary;
        }

        public void setPrimary(int primary) {
            this.primary = primary;
        }

        public static class HourlyBean {
            /**
             * status : ok
             * description : 晴，3点钟后多云，转小雨，明天早晨8点钟后雨停
             * skycon : [{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-13 11:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-13 12:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-13 13:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-13 14:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-13 15:00"},{"value":"CLEAR_DAY","datetime":"2017-03-13 16:00"},{"value":"CLEAR_DAY","datetime":"2017-03-13 17:00"},{"value":"CLEAR_DAY","datetime":"2017-03-13 18:00"},{"value":"CLEAR_NIGHT","datetime":"2017-03-13 19:00"},{"value":"CLEAR_NIGHT","datetime":"2017-03-13 20:00"},{"value":"CLEAR_NIGHT","datetime":"2017-03-13 21:00"},{"value":"CLEAR_NIGHT","datetime":"2017-03-13 22:00"},{"value":"CLEAR_NIGHT","datetime":"2017-03-13 23:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-14 00:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-14 01:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-14 02:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-14 03:00"},{"value":"RAIN","datetime":"2017-03-14 04:00"},{"value":"RAIN","datetime":"2017-03-14 05:00"},{"value":"RAIN","datetime":"2017-03-14 06:00"},{"value":"RAIN","datetime":"2017-03-14 07:00"},{"value":"RAIN","datetime":"2017-03-14 08:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-14 09:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-14 10:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-14 11:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-14 12:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-14 13:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-14 14:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-14 15:00"},{"value":"CLOUDY","datetime":"2017-03-14 16:00"},{"value":"CLOUDY","datetime":"2017-03-14 17:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-14 18:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-14 19:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-14 20:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-14 21:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-14 22:00"},{"value":"CLOUDY","datetime":"2017-03-14 23:00"},{"value":"CLOUDY","datetime":"2017-03-15 00:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-15 01:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-15 02:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-15 03:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-15 04:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-15 05:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2017-03-15 06:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-15 07:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-15 08:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-15 09:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2017-03-15 10:00"}]
             * cloudrate : [{"value":0.48,"datetime":"2017-03-13 11:00"},{"value":0.47,"datetime":"2017-03-13 12:00"},{"value":0.43,"datetime":"2017-03-13 13:00"},{"value":0.35,"datetime":"2017-03-13 14:00"},{"value":0.23,"datetime":"2017-03-13 15:00"},{"value":0.1,"datetime":"2017-03-13 16:00"},{"value":0.01,"datetime":"2017-03-13 17:00"},{"value":0,"datetime":"2017-03-13 18:00"},{"value":0,"datetime":"2017-03-13 19:00"},{"value":0.01,"datetime":"2017-03-13 20:00"},{"value":0.05,"datetime":"2017-03-13 21:00"},{"value":0.1,"datetime":"2017-03-13 22:00"},{"value":0.15,"datetime":"2017-03-13 23:00"},{"value":0.21,"datetime":"2017-03-14 00:00"},{"value":0.24,"datetime":"2017-03-14 01:00"},{"value":0.25,"datetime":"2017-03-14 02:00"},{"value":0.22,"datetime":"2017-03-14 03:00"},{"value":0.18,"datetime":"2017-03-14 04:00"},{"value":0.16,"datetime":"2017-03-14 05:00"},{"value":0.19,"datetime":"2017-03-14 06:00"},{"value":0.26,"datetime":"2017-03-14 07:00"},{"value":0.34,"datetime":"2017-03-14 08:00"},{"value":0.41,"datetime":"2017-03-14 09:00"},{"value":0.47,"datetime":"2017-03-14 10:00"},{"value":0.51,"datetime":"2017-03-14 11:00"},{"value":0.52,"datetime":"2017-03-14 12:00"},{"value":0.54,"datetime":"2017-03-14 13:00"},{"value":0.6,"datetime":"2017-03-14 14:00"},{"value":0.7,"datetime":"2017-03-14 15:00"},{"value":0.81,"datetime":"2017-03-14 16:00"},{"value":0.84,"datetime":"2017-03-14 17:00"},{"value":0.76,"datetime":"2017-03-14 18:00"},{"value":0.64,"datetime":"2017-03-14 19:00"},{"value":0.58,"datetime":"2017-03-14 20:00"},{"value":0.64,"datetime":"2017-03-14 21:00"},{"value":0.77,"datetime":"2017-03-14 22:00"},{"value":0.87,"datetime":"2017-03-14 23:00"},{"value":0.87,"datetime":"2017-03-15 00:00"},{"value":0.8,"datetime":"2017-03-15 01:00"},{"value":0.7,"datetime":"2017-03-15 02:00"},{"value":0.61,"datetime":"2017-03-15 03:00"},{"value":0.54,"datetime":"2017-03-15 04:00"},{"value":0.5,"datetime":"2017-03-15 05:00"},{"value":0.49,"datetime":"2017-03-15 06:00"},{"value":0.52,"datetime":"2017-03-15 07:00"},{"value":0.57,"datetime":"2017-03-15 08:00"},{"value":0.65,"datetime":"2017-03-15 09:00"},{"value":0.71,"datetime":"2017-03-15 10:00"}]
             * aqi : [{"value":52,"datetime":"2017-03-13 11:00"},{"value":49,"datetime":"2017-03-13 12:00"},{"value":46,"datetime":"2017-03-13 13:00"},{"value":43,"datetime":"2017-03-13 14:00"},{"value":42,"datetime":"2017-03-13 15:00"},{"value":39,"datetime":"2017-03-13 16:00"},{"value":38,"datetime":"2017-03-13 17:00"},{"value":38,"datetime":"2017-03-13 18:00"},{"value":38,"datetime":"2017-03-13 19:00"},{"value":38,"datetime":"2017-03-13 20:00"},{"value":39,"datetime":"2017-03-13 21:00"},{"value":41,"datetime":"2017-03-13 22:00"},{"value":42,"datetime":"2017-03-13 23:00"},{"value":42,"datetime":"2017-03-14 00:00"},{"value":42,"datetime":"2017-03-14 01:00"},{"value":42,"datetime":"2017-03-14 02:00"},{"value":41,"datetime":"2017-03-14 03:00"},{"value":41,"datetime":"2017-03-14 04:00"},{"value":38,"datetime":"2017-03-14 05:00"},{"value":37,"datetime":"2017-03-14 06:00"},{"value":34,"datetime":"2017-03-14 07:00"},{"value":31,"datetime":"2017-03-14 08:00"},{"value":30,"datetime":"2017-03-14 09:00"},{"value":30,"datetime":"2017-03-14 10:00"},{"value":29,"datetime":"2017-03-14 11:00"},{"value":27,"datetime":"2017-03-14 12:00"},{"value":26,"datetime":"2017-03-14 13:00"},{"value":26,"datetime":"2017-03-14 14:00"},{"value":29,"datetime":"2017-03-14 15:00"},{"value":33,"datetime":"2017-03-14 16:00"},{"value":38,"datetime":"2017-03-14 17:00"},{"value":41,"datetime":"2017-03-14 18:00"},{"value":45,"datetime":"2017-03-14 19:00"},{"value":47,"datetime":"2017-03-14 20:00"},{"value":49,"datetime":"2017-03-14 21:00"},{"value":50,"datetime":"2017-03-14 22:00"},{"value":52,"datetime":"2017-03-14 23:00"},{"value":53,"datetime":"2017-03-15 00:00"},{"value":53,"datetime":"2017-03-15 01:00"},{"value":55,"datetime":"2017-03-15 02:00"},{"value":53,"datetime":"2017-03-15 03:00"},{"value":53,"datetime":"2017-03-15 04:00"},{"value":53,"datetime":"2017-03-15 05:00"},{"value":52,"datetime":"2017-03-15 06:00"},{"value":52,"datetime":"2017-03-15 07:00"},{"value":52,"datetime":"2017-03-15 08:00"},{"value":53,"datetime":"2017-03-15 09:00"},{"value":55,"datetime":"2017-03-15 10:00"}]
             * humidity : [{"value":0.72,"datetime":"2017-03-13 11:00"},{"value":0.67,"datetime":"2017-03-13 12:00"},{"value":0.65,"datetime":"2017-03-13 13:00"},{"value":0.64,"datetime":"2017-03-13 14:00"},{"value":0.65,"datetime":"2017-03-13 15:00"},{"value":0.68,"datetime":"2017-03-13 16:00"},{"value":0.73,"datetime":"2017-03-13 17:00"},{"value":0.77,"datetime":"2017-03-13 18:00"},{"value":0.82,"datetime":"2017-03-13 19:00"},{"value":0.86,"datetime":"2017-03-13 20:00"},{"value":0.88,"datetime":"2017-03-13 21:00"},{"value":0.9,"datetime":"2017-03-13 22:00"},{"value":0.91,"datetime":"2017-03-13 23:00"},{"value":0.92,"datetime":"2017-03-14 00:00"},{"value":0.93,"datetime":"2017-03-14 01:00"},{"value":0.93,"datetime":"2017-03-14 02:00"},{"value":0.94,"datetime":"2017-03-14 03:00"},{"value":0.94,"datetime":"2017-03-14 04:00"},{"value":0.93,"datetime":"2017-03-14 05:00"},{"value":0.92,"datetime":"2017-03-14 06:00"},{"value":0.89,"datetime":"2017-03-14 07:00"},{"value":0.84,"datetime":"2017-03-14 08:00"},{"value":0.77,"datetime":"2017-03-14 09:00"},{"value":0.7,"datetime":"2017-03-14 10:00"},{"value":0.66,"datetime":"2017-03-14 11:00"},{"value":0.65,"datetime":"2017-03-14 12:00"},{"value":0.66,"datetime":"2017-03-14 13:00"},{"value":0.68,"datetime":"2017-03-14 14:00"},{"value":0.69,"datetime":"2017-03-14 15:00"},{"value":0.69,"datetime":"2017-03-14 16:00"},{"value":0.7,"datetime":"2017-03-14 17:00"},{"value":0.72,"datetime":"2017-03-14 18:00"},{"value":0.75,"datetime":"2017-03-14 19:00"},{"value":0.77,"datetime":"2017-03-14 20:00"},{"value":0.78,"datetime":"2017-03-14 21:00"},{"value":0.78,"datetime":"2017-03-14 22:00"},{"value":0.78,"datetime":"2017-03-14 23:00"},{"value":0.79,"datetime":"2017-03-15 00:00"},{"value":0.8,"datetime":"2017-03-15 01:00"},{"value":0.8,"datetime":"2017-03-15 02:00"},{"value":0.8,"datetime":"2017-03-15 03:00"},{"value":0.8,"datetime":"2017-03-15 04:00"},{"value":0.8,"datetime":"2017-03-15 05:00"},{"value":0.79,"datetime":"2017-03-15 06:00"},{"value":0.79,"datetime":"2017-03-15 07:00"},{"value":0.77,"datetime":"2017-03-15 08:00"},{"value":0.74,"datetime":"2017-03-15 09:00"},{"value":0.71,"datetime":"2017-03-15 10:00"}]
             * pm25 : [{"value":35,"datetime":"2017-03-13 11:00"},{"value":34,"datetime":"2017-03-13 12:00"},{"value":32,"datetime":"2017-03-13 13:00"},{"value":30,"datetime":"2017-03-13 14:00"},{"value":29,"datetime":"2017-03-13 15:00"},{"value":27,"datetime":"2017-03-13 16:00"},{"value":26,"datetime":"2017-03-13 17:00"},{"value":26,"datetime":"2017-03-13 18:00"},{"value":26,"datetime":"2017-03-13 19:00"},{"value":26,"datetime":"2017-03-13 20:00"},{"value":27,"datetime":"2017-03-13 21:00"},{"value":28,"datetime":"2017-03-13 22:00"},{"value":29,"datetime":"2017-03-13 23:00"},{"value":29,"datetime":"2017-03-14 00:00"},{"value":29,"datetime":"2017-03-14 01:00"},{"value":29,"datetime":"2017-03-14 02:00"},{"value":28,"datetime":"2017-03-14 03:00"},{"value":28,"datetime":"2017-03-14 04:00"},{"value":26,"datetime":"2017-03-14 05:00"},{"value":25,"datetime":"2017-03-14 06:00"},{"value":23,"datetime":"2017-03-14 07:00"},{"value":21,"datetime":"2017-03-14 08:00"},{"value":20,"datetime":"2017-03-14 09:00"},{"value":20,"datetime":"2017-03-14 10:00"},{"value":19,"datetime":"2017-03-14 11:00"},{"value":18,"datetime":"2017-03-14 12:00"},{"value":17,"datetime":"2017-03-14 13:00"},{"value":17,"datetime":"2017-03-14 14:00"},{"value":19,"datetime":"2017-03-14 15:00"},{"value":22,"datetime":"2017-03-14 16:00"},{"value":26,"datetime":"2017-03-14 17:00"},{"value":28,"datetime":"2017-03-14 18:00"},{"value":31,"datetime":"2017-03-14 19:00"},{"value":33,"datetime":"2017-03-14 20:00"},{"value":34,"datetime":"2017-03-14 21:00"},{"value":35,"datetime":"2017-03-14 22:00"},{"value":36,"datetime":"2017-03-14 23:00"},{"value":37,"datetime":"2017-03-15 00:00"},{"value":37,"datetime":"2017-03-15 01:00"},{"value":38,"datetime":"2017-03-15 02:00"},{"value":37,"datetime":"2017-03-15 03:00"},{"value":37,"datetime":"2017-03-15 04:00"},{"value":37,"datetime":"2017-03-15 05:00"},{"value":36,"datetime":"2017-03-15 06:00"},{"value":36,"datetime":"2017-03-15 07:00"},{"value":36,"datetime":"2017-03-15 08:00"},{"value":37,"datetime":"2017-03-15 09:00"},{"value":38,"datetime":"2017-03-15 10:00"}]
             * precipitation : [{"value":0,"datetime":"2017-03-13 11:00"},{"value":0,"datetime":"2017-03-13 12:00"},{"value":0,"datetime":"2017-03-13 13:00"},{"value":0,"datetime":"2017-03-13 14:00"},{"value":0,"datetime":"2017-03-13 15:00"},{"value":0,"datetime":"2017-03-13 16:00"},{"value":0,"datetime":"2017-03-13 17:00"},{"value":0,"datetime":"2017-03-13 18:00"},{"value":0,"datetime":"2017-03-13 19:00"},{"value":0,"datetime":"2017-03-13 20:00"},{"value":0,"datetime":"2017-03-13 21:00"},{"value":0,"datetime":"2017-03-13 22:00"},{"value":0,"datetime":"2017-03-13 23:00"},{"value":0,"datetime":"2017-03-14 00:00"},{"value":0,"datetime":"2017-03-14 01:00"},{"value":0,"datetime":"2017-03-14 02:00"},{"value":0,"datetime":"2017-03-14 03:00"},{"value":0.0712,"datetime":"2017-03-14 04:00"},{"value":0.0982,"datetime":"2017-03-14 05:00"},{"value":0.1015,"datetime":"2017-03-14 06:00"},{"value":0.0873,"datetime":"2017-03-14 07:00"},{"value":0.0665,"datetime":"2017-03-14 08:00"},{"value":0.0485,"datetime":"2017-03-14 09:00"},{"value":0,"datetime":"2017-03-14 10:00"},{"value":0,"datetime":"2017-03-14 11:00"},{"value":0,"datetime":"2017-03-14 12:00"},{"value":0,"datetime":"2017-03-14 13:00"},{"value":0,"datetime":"2017-03-14 14:00"},{"value":0,"datetime":"2017-03-14 15:00"},{"value":0,"datetime":"2017-03-14 16:00"},{"value":0,"datetime":"2017-03-14 17:00"},{"value":0,"datetime":"2017-03-14 18:00"},{"value":0,"datetime":"2017-03-14 19:00"},{"value":0,"datetime":"2017-03-14 20:00"},{"value":0,"datetime":"2017-03-14 21:00"},{"value":0,"datetime":"2017-03-14 22:00"},{"value":0,"datetime":"2017-03-14 23:00"},{"value":0,"datetime":"2017-03-15 00:00"},{"value":0,"datetime":"2017-03-15 01:00"},{"value":0,"datetime":"2017-03-15 02:00"},{"value":0,"datetime":"2017-03-15 03:00"},{"value":0,"datetime":"2017-03-15 04:00"},{"value":0,"datetime":"2017-03-15 05:00"},{"value":0,"datetime":"2017-03-15 06:00"},{"value":0,"datetime":"2017-03-15 07:00"},{"value":0,"datetime":"2017-03-15 08:00"},{"value":0,"datetime":"2017-03-15 09:00"},{"value":0,"datetime":"2017-03-15 10:00"}]
             * wind : [{"direction":167.14,"speed":7.19,"datetime":"2017-03-13 11:00"},{"direction":184.24,"speed":9.56,"datetime":"2017-03-13 12:00"},{"direction":191.94,"speed":12.49,"datetime":"2017-03-13 13:00"},{"direction":194.06,"speed":15.04,"datetime":"2017-03-13 14:00"},{"direction":192.68,"speed":16.61,"datetime":"2017-03-13 15:00"},{"direction":189.22,"speed":17.09,"datetime":"2017-03-13 16:00"},{"direction":184.26,"speed":16.48,"datetime":"2017-03-13 17:00"},{"direction":177.72,"speed":14.88,"datetime":"2017-03-13 18:00"},{"direction":169.33,"speed":12.81,"datetime":"2017-03-13 19:00"},{"direction":159.64,"speed":10.8,"datetime":"2017-03-13 20:00"},{"direction":150.51,"speed":9.12,"datetime":"2017-03-13 21:00"},{"direction":142.75,"speed":7.78,"datetime":"2017-03-13 22:00"},{"direction":136.96,"speed":6.82,"datetime":"2017-03-13 23:00"},{"direction":133.38,"speed":6.21,"datetime":"2017-03-14 00:00"},{"direction":128.72,"speed":5.52,"datetime":"2017-03-14 01:00"},{"direction":114.59,"speed":4.42,"datetime":"2017-03-14 02:00"},{"direction":75.15,"speed":3.82,"datetime":"2017-03-14 03:00"},{"direction":40.86,"speed":5.49,"datetime":"2017-03-14 04:00"},{"direction":31.92,"speed":7.69,"datetime":"2017-03-14 05:00"},{"direction":36.3,"speed":9.05,"datetime":"2017-03-14 06:00"},{"direction":46.07,"speed":10.27,"datetime":"2017-03-14 07:00"},{"direction":54.82,"speed":12.26,"datetime":"2017-03-14 08:00"},{"direction":58.74,"speed":15.1,"datetime":"2017-03-14 09:00"},{"direction":59.29,"speed":17.57,"datetime":"2017-03-14 10:00"},{"direction":57.96,"speed":18.26,"datetime":"2017-03-14 11:00"},{"direction":55.1,"speed":16.36,"datetime":"2017-03-14 12:00"},{"direction":52.31,"speed":13.15,"datetime":"2017-03-14 13:00"},{"direction":54.87,"speed":10.33,"datetime":"2017-03-14 14:00"},{"direction":69.23,"speed":9.51,"datetime":"2017-03-14 15:00"},{"direction":84.37,"speed":10.65,"datetime":"2017-03-14 16:00"},{"direction":91.11,"speed":11.77,"datetime":"2017-03-14 17:00"},{"direction":89.76,"speed":11.16,"datetime":"2017-03-14 18:00"},{"direction":83.41,"speed":9.73,"datetime":"2017-03-14 19:00"},{"direction":77.7,"speed":8.96,"datetime":"2017-03-14 20:00"},{"direction":79.89,"speed":9.56,"datetime":"2017-03-14 21:00"},{"direction":84.84,"speed":10.88,"datetime":"2017-03-14 22:00"},{"direction":86.63,"speed":11.8,"datetime":"2017-03-14 23:00"},{"direction":82.76,"speed":11.42,"datetime":"2017-03-15 00:00"},{"direction":74.45,"speed":10.31,"datetime":"2017-03-15 01:00"},{"direction":64.67,"speed":9.24,"datetime":"2017-03-15 02:00"},{"direction":58.51,"speed":8.52,"datetime":"2017-03-15 03:00"},{"direction":57.72,"speed":8.11,"datetime":"2017-03-15 04:00"},{"direction":62.01,"speed":8.18,"datetime":"2017-03-15 05:00"},{"direction":69.15,"speed":8.91,"datetime":"2017-03-15 06:00"},{"direction":76.19,"speed":10.02,"datetime":"2017-03-15 07:00"},{"direction":82.03,"speed":10.99,"datetime":"2017-03-15 08:00"},{"direction":87.23,"speed":11.4,"datetime":"2017-03-15 09:00"},{"direction":93.52,"speed":11.48,"datetime":"2017-03-15 10:00"}]
             * temperature : [{"value":24,"datetime":"2017-03-13 11:00"},{"value":25.01,"datetime":"2017-03-13 12:00"},{"value":25.69,"datetime":"2017-03-13 13:00"},{"value":25.93,"datetime":"2017-03-13 14:00"},{"value":25.66,"datetime":"2017-03-13 15:00"},{"value":25.01,"datetime":"2017-03-13 16:00"},{"value":24.13,"datetime":"2017-03-13 17:00"},{"value":23.2,"datetime":"2017-03-13 18:00"},{"value":22.34,"datetime":"2017-03-13 19:00"},{"value":21.67,"datetime":"2017-03-13 20:00"},{"value":21.29,"datetime":"2017-03-13 21:00"},{"value":21.1,"datetime":"2017-03-13 22:00"},{"value":21,"datetime":"2017-03-13 23:00"},{"value":20.86,"datetime":"2017-03-14 00:00"},{"value":20.7,"datetime":"2017-03-14 01:00"},{"value":20.53,"datetime":"2017-03-14 02:00"},{"value":20.37,"datetime":"2017-03-14 03:00"},{"value":20.26,"datetime":"2017-03-14 04:00"},{"value":20.27,"datetime":"2017-03-14 05:00"},{"value":20.43,"datetime":"2017-03-14 06:00"},{"value":20.7,"datetime":"2017-03-14 07:00"},{"value":21.06,"datetime":"2017-03-14 08:00"},{"value":21.43,"datetime":"2017-03-14 09:00"},{"value":21.76,"datetime":"2017-03-14 10:00"},{"value":21.96,"datetime":"2017-03-14 11:00"},{"value":21.99,"datetime":"2017-03-14 12:00"},{"value":21.91,"datetime":"2017-03-14 13:00"},{"value":21.79,"datetime":"2017-03-14 14:00"},{"value":21.69,"datetime":"2017-03-14 15:00"},{"value":21.51,"datetime":"2017-03-14 16:00"},{"value":21.15,"datetime":"2017-03-14 17:00"},{"value":20.53,"datetime":"2017-03-14 18:00"},{"value":19.81,"datetime":"2017-03-14 19:00"},{"value":19.18,"datetime":"2017-03-14 20:00"},{"value":18.79,"datetime":"2017-03-14 21:00"},{"value":18.55,"datetime":"2017-03-14 22:00"},{"value":18.3,"datetime":"2017-03-14 23:00"},{"value":17.93,"datetime":"2017-03-15 00:00"},{"value":17.52,"datetime":"2017-03-15 01:00"},{"value":17.16,"datetime":"2017-03-15 02:00"},{"value":16.96,"datetime":"2017-03-15 03:00"},{"value":16.87,"datetime":"2017-03-15 04:00"},{"value":16.83,"datetime":"2017-03-15 05:00"},{"value":16.8,"datetime":"2017-03-15 06:00"},{"value":16.89,"datetime":"2017-03-15 07:00"},{"value":17.23,"datetime":"2017-03-15 08:00"},{"value":17.92,"datetime":"2017-03-15 09:00"},{"value":18.84,"datetime":"2017-03-15 10:00"}]
             */

            private String status;
            private String description;
            private List<SkyconBean> skycon;
            private List<CloudrateBean> cloudrate;
            private List<AqiBean> aqi;
            private List<HumidityBean> humidity;
            private List<Pm25Bean> pm25;
            private List<PrecipitationBean> precipitation;
            private List<WindBean> wind;
            private List<TemperatureBean> temperature;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public List<SkyconBean> getSkycon() {
                return skycon;
            }

            public void setSkycon(List<SkyconBean> skycon) {
                this.skycon = skycon;
            }

            public List<CloudrateBean> getCloudrate() {
                return cloudrate;
            }

            public void setCloudrate(List<CloudrateBean> cloudrate) {
                this.cloudrate = cloudrate;
            }

            public List<AqiBean> getAqi() {
                return aqi;
            }

            public void setAqi(List<AqiBean> aqi) {
                this.aqi = aqi;
            }

            public List<HumidityBean> getHumidity() {
                return humidity;
            }

            public void setHumidity(List<HumidityBean> humidity) {
                this.humidity = humidity;
            }

            public List<Pm25Bean> getPm25() {
                return pm25;
            }

            public void setPm25(List<Pm25Bean> pm25) {
                this.pm25 = pm25;
            }

            public List<PrecipitationBean> getPrecipitation() {
                return precipitation;
            }

            public void setPrecipitation(List<PrecipitationBean> precipitation) {
                this.precipitation = precipitation;
            }

            public List<WindBean> getWind() {
                return wind;
            }

            public void setWind(List<WindBean> wind) {
                this.wind = wind;
            }

            public List<TemperatureBean> getTemperature() {
                return temperature;
            }

            public void setTemperature(List<TemperatureBean> temperature) {
                this.temperature = temperature;
            }

            public static class SkyconBean {
                /**
                 * value : PARTLY_CLOUDY_DAY
                 * datetime : 2017-03-13 11:00
                 */

                private String value;
                private String datetime;

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }
            }

            public static class CloudrateBean {
                /**
                 * value : 0.48
                 * datetime : 2017-03-13 11:00
                 */

                private double value;
                private String datetime;

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }
            }

            public static class AqiBean {
                /**
                 * value : 52
                 * datetime : 2017-03-13 11:00
                 */

                private int value;
                private String datetime;

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }
            }

            public static class HumidityBean {
                /**
                 * value : 0.72
                 * datetime : 2017-03-13 11:00
                 */

                private double value;
                private String datetime;

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }
            }

            public static class Pm25Bean {
                /**
                 * value : 35
                 * datetime : 2017-03-13 11:00
                 */

                private int value;
                private String datetime;

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }
            }

            public static class PrecipitationBean {
                /**
                 * value : 0
                 * datetime : 2017-03-13 11:00
                 */

                private double value;
                private String datetime;

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }
            }

            public static class WindBean {
                /**
                 * direction : 167.14
                 * speed : 7.19
                 * datetime : 2017-03-13 11:00
                 */

                private double direction;
                private double speed;
                private String datetime;

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

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }
            }

            public static class TemperatureBean {
                /**
                 * value : 24
                 * datetime : 2017-03-13 11:00
                 */

                private double value;
                private String datetime;

                public double getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }
            }
        }

        public static class MinutelyBean {
            /**
             * status : ok
             * description : 未来两小时不会下雨，放心出门吧
             * probability : [0.0667725578,0.1027696803,0.1439363807,0.1639839709]
             * datasource : radar
             * precipitation_2h : [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
             * precipitation : [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
             */

            private String status;
            private String description;
            private String datasource;
            private List<Double> probability;
            private List<Double> precipitation_2h;
            private List<Double> precipitation;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getDatasource() {
                return datasource;
            }

            public void setDatasource(String datasource) {
                this.datasource = datasource;
            }

            public List<Double> getProbability() {
                return probability;
            }

            public void setProbability(List<Double> probability) {
                this.probability = probability;
            }

            public List<Double> getPrecipitation_2h() {
                return precipitation_2h;
            }

            public void setPrecipitation_2h(List<Double> precipitation_2h) {
                this.precipitation_2h = precipitation_2h;
            }

            public List<Double> getPrecipitation() {
                return precipitation;
            }

            public void setPrecipitation(List<Double> precipitation) {
                this.precipitation = precipitation;
            }
        }

        public static class DailyBean {
            /**
             * status : ok
             * coldRisk : [{"index":"3","desc":"易发","datetime":"2017-03-13"},{"index":"3","desc":"易发","datetime":"2017-03-14"},{"index":"3","desc":"易发","datetime":"2017-03-15"},{"index":"4","desc":"极易发","datetime":"2017-03-16"},{"index":"3","desc":"易发","datetime":"2017-03-17"}]
             * temperature : [{"date":"2017-03-13","max":25.93,"avg":23.54,"min":18.99},{"date":"2017-03-14","max":21.99,"avg":20.65,"min":18.3},{"date":"2017-03-15","max":21.68,"avg":18.57,"min":16.8},{"date":"2017-03-16","max":23.72,"avg":19.44,"min":16.36},{"date":"2017-03-17","max":23.51,"avg":20.07,"min":17.22}]
             * skycon : [{"date":"2017-03-13","value":"CLEAR_DAY"},{"date":"2017-03-14","value":"PARTLY_CLOUDY_DAY"},{"date":"2017-03-15","value":"PARTLY_CLOUDY_DAY"},{"date":"2017-03-16","value":"PARTLY_CLOUDY_DAY"},{"date":"2017-03-17","value":"PARTLY_CLOUDY_DAY"}]
             * cloudrate : [{"date":"2017-03-13","max":0.9,"avg":0.18,"min":0},{"date":"2017-03-14","max":0.87,"avg":0.49,"min":0.16},{"date":"2017-03-15","max":0.87,"avg":0.68,"min":0.49},{"date":"2017-03-16","max":0.78,"avg":0.38,"min":0.05},{"date":"2017-03-17","max":0.71,"avg":0.36,"min":0}]
             * aqi : [{"date":"2017-03-13","max":79,"avg":41.92,"min":38},{"date":"2017-03-14","max":52,"avg":37.5,"min":26},{"date":"2017-03-15","max":56,"avg":53.08,"min":50},{"date":"2017-03-16","max":55,"avg":48,"min":39},{"date":"2017-03-17","max":41,"avg":37.67,"min":35}]
             * humidity : [{"date":"2017-03-13","max":0.95,"avg":0.76,"min":0.64},{"date":"2017-03-14","max":0.94,"avg":0.79,"min":0.65},{"date":"2017-03-15","max":0.8,"avg":0.71,"min":0.6},{"date":"2017-03-16","max":0.82,"avg":0.73,"min":0.6},{"date":"2017-03-17","max":0.87,"avg":0.76,"min":0.63}]
             * astro : [{"date":"2017-03-13","sunset":{"time":"18:32"},"sunrise":{"time":"06:34"}},{"date":"2017-03-14","sunset":{"time":"18:33"},"sunrise":{"time":"06:33"}},{"date":"2017-03-15","sunset":{"time":"18:33"},"sunrise":{"time":"06:32"}},{"date":"2017-03-16","sunset":{"time":"18:33"},"sunrise":{"time":"06:32"}},{"date":"2017-03-17","sunset":{"time":"18:34"},"sunrise":{"time":"06:31"}}]
             * ultraviolet : [{"index":"3","desc":"中等","datetime":"2017-03-13"},{"index":"3","desc":"中等","datetime":"2017-03-14"},{"index":"2","desc":"弱","datetime":"2017-03-15"},{"index":"2","desc":"弱","datetime":"2017-03-16"},{"index":"2","desc":"弱","datetime":"2017-03-17"}]
             * pm25 : [{"date":"2017-03-13","max":58,"avg":28.85,"min":26},{"date":"2017-03-14","max":36,"avg":25.54,"min":17},{"date":"2017-03-15","max":39,"avg":36.92,"min":35},{"date":"2017-03-16","max":38,"avg":33.33,"min":27},{"date":"2017-03-17","max":28,"avg":25.75,"min":24}]
             * dressing : [{"index":"3","desc":"热","datetime":"2017-03-13"},{"index":"4","desc":"温暖","datetime":"2017-03-14"},{"index":"4","desc":"温暖","datetime":"2017-03-15"},{"index":"4","desc":"温暖","datetime":"2017-03-16"},{"index":"4","desc":"温暖","datetime":"2017-03-17"}]
             * carWashing : [{"index":"1","desc":"适宜","datetime":"2017-03-13"},{"index":"3","desc":"较不适宜","datetime":"2017-03-14"},{"index":"1","desc":"适宜","datetime":"2017-03-15"},{"index":"1","desc":"适宜","datetime":"2017-03-16"},{"index":"1","desc":"适宜","datetime":"2017-03-17"}]
             * precipitation : [{"date":"2017-03-13","max":0,"avg":0,"min":0},{"date":"2017-03-14","max":0.1015,"avg":0.0197,"min":0},{"date":"2017-03-15","max":0,"avg":0,"min":0},{"date":"2017-03-16","max":0,"avg":0,"min":0},{"date":"2017-03-17","max":0,"avg":0,"min":0}]
             * wind : [{"date":"2017-03-13","max":{"direction":189.22,"speed":17.09},"avg":{"direction":158.35,"speed":10.59},"min":{"direction":141.91,"speed":6.43}},{"date":"2017-03-14","max":{"direction":57.96,"speed":18.26},"avg":{"direction":68.71,"speed":10.4},"min":{"direction":75.15,"speed":3.82}},{"date":"2017-03-15","max":{"direction":123.42,"speed":16.3},"avg":{"direction":102.97,"speed":12.48},"min":{"direction":57.72,"speed":8.11}},{"date":"2017-03-16","max":{"direction":129.87,"speed":14.86},"avg":{"direction":114.64,"speed":11.32},"min":{"direction":87.19,"speed":8.23}},{"date":"2017-03-17","max":{"direction":136.23,"speed":17.48},"avg":{"direction":113.5,"speed":13.13},"min":{"direction":93.33,"speed":9.24}}]
             */

            private String status;
            private List<ColdRiskBean> coldRisk;
            private List<TemperatureBeanX> temperature;
            private List<SkyconBeanX> skycon;
            private List<CloudrateBeanX> cloudrate;
            private List<AqiBeanX> aqi;
            private List<HumidityBeanX> humidity;
            private List<AstroBean> astro;
            private List<UltravioletBean> ultraviolet;
            private List<Pm25BeanX> pm25;
            private List<DressingBean> dressing;
            private List<CarWashingBean> carWashing;
            private List<PrecipitationBeanX> precipitation;
            private List<WindBeanX> wind;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public List<ColdRiskBean> getColdRisk() {
                return coldRisk;
            }

            public void setColdRisk(List<ColdRiskBean> coldRisk) {
                this.coldRisk = coldRisk;
            }

            public List<TemperatureBeanX> getTemperature() {
                return temperature;
            }

            public void setTemperature(List<TemperatureBeanX> temperature) {
                this.temperature = temperature;
            }

            public List<SkyconBeanX> getSkycon() {
                return skycon;
            }

            public void setSkycon(List<SkyconBeanX> skycon) {
                this.skycon = skycon;
            }

            public List<CloudrateBeanX> getCloudrate() {
                return cloudrate;
            }

            public void setCloudrate(List<CloudrateBeanX> cloudrate) {
                this.cloudrate = cloudrate;
            }

            public List<AqiBeanX> getAqi() {
                return aqi;
            }

            public void setAqi(List<AqiBeanX> aqi) {
                this.aqi = aqi;
            }

            public List<HumidityBeanX> getHumidity() {
                return humidity;
            }

            public void setHumidity(List<HumidityBeanX> humidity) {
                this.humidity = humidity;
            }

            public List<AstroBean> getAstro() {
                return astro;
            }

            public void setAstro(List<AstroBean> astro) {
                this.astro = astro;
            }

            public List<UltravioletBean> getUltraviolet() {
                return ultraviolet;
            }

            public void setUltraviolet(List<UltravioletBean> ultraviolet) {
                this.ultraviolet = ultraviolet;
            }

            public List<Pm25BeanX> getPm25() {
                return pm25;
            }

            public void setPm25(List<Pm25BeanX> pm25) {
                this.pm25 = pm25;
            }

            public List<DressingBean> getDressing() {
                return dressing;
            }

            public void setDressing(List<DressingBean> dressing) {
                this.dressing = dressing;
            }

            public List<CarWashingBean> getCarWashing() {
                return carWashing;
            }

            public void setCarWashing(List<CarWashingBean> carWashing) {
                this.carWashing = carWashing;
            }

            public List<PrecipitationBeanX> getPrecipitation() {
                return precipitation;
            }

            public void setPrecipitation(List<PrecipitationBeanX> precipitation) {
                this.precipitation = precipitation;
            }

            public List<WindBeanX> getWind() {
                return wind;
            }

            public void setWind(List<WindBeanX> wind) {
                this.wind = wind;
            }

            public static class ColdRiskBean {
                /**
                 * index : 3
                 * desc : 易发
                 * datetime : 2017-03-13
                 */

                private String index;
                private String desc;
                private String datetime;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }
            }

            public static class TemperatureBeanX {
                /**
                 * date : 2017-03-13
                 * max : 25.93
                 * avg : 23.54
                 * min : 18.99
                 */

                private String date;
                private double max;
                private double avg;
                private double min;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }
            }

            public static class SkyconBeanX {
                /**
                 * date : 2017-03-13
                 * value : CLEAR_DAY
                 */

                private String date;
                private String value;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class CloudrateBeanX {
                /**
                 * date : 2017-03-13
                 * max : 0.9
                 * avg : 0.18
                 * min : 0
                 */

                private String date;
                private double max;
                private double avg;
                private double min;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(int min) {
                    this.min = min;
                }
            }

            public static class AqiBeanX {
                /**
                 * date : 2017-03-13
                 * max : 79
                 * avg : 41.92
                 * min : 38
                 */

                private String date;
                private int max;
                private double avg;
                private int min;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public int getMax() {
                    return max;
                }

                public void setMax(int max) {
                    this.max = max;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }

                public int getMin() {
                    return min;
                }

                public void setMin(int min) {
                    this.min = min;
                }
            }

            public static class HumidityBeanX {
                /**
                 * date : 2017-03-13
                 * max : 0.95
                 * avg : 0.76
                 * min : 0.64
                 */

                private String date;
                private double max;
                private double avg;
                private double min;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }
            }

            public static class AstroBean {
                /**
                 * date : 2017-03-13
                 * sunset : {"time":"18:32"}
                 * sunrise : {"time":"06:34"}
                 */

                private String date;
                private SunsetBean sunset;
                private SunriseBean sunrise;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public SunsetBean getSunset() {
                    return sunset;
                }

                public void setSunset(SunsetBean sunset) {
                    this.sunset = sunset;
                }

                public SunriseBean getSunrise() {
                    return sunrise;
                }

                public void setSunrise(SunriseBean sunrise) {
                    this.sunrise = sunrise;
                }

                public static class SunsetBean {
                    /**
                     * time : 18:32
                     */

                    private String time;

                    public String getTime() {
                        return time;
                    }

                    public void setTime(String time) {
                        this.time = time;
                    }
                }

                public static class SunriseBean {
                    /**
                     * time : 06:34
                     */

                    private String time;

                    public String getTime() {
                        return time;
                    }

                    public void setTime(String time) {
                        this.time = time;
                    }
                }
            }

            public static class UltravioletBean {
                /**
                 * index : 3
                 * desc : 中等
                 * datetime : 2017-03-13
                 */

                private String index;
                private String desc;
                private String datetime;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }
            }

            public static class Pm25BeanX {
                /**
                 * date : 2017-03-13
                 * max : 58
                 * avg : 28.85
                 * min : 26
                 */

                private String date;
                private int max;
                private double avg;
                private int min;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public int getMax() {
                    return max;
                }

                public void setMax(int max) {
                    this.max = max;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }

                public int getMin() {
                    return min;
                }

                public void setMin(int min) {
                    this.min = min;
                }
            }

            public static class DressingBean {
                /**
                 * index : 3
                 * desc : 热
                 * datetime : 2017-03-13
                 */

                private String index;
                private String desc;
                private String datetime;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }
            }

            public static class CarWashingBean {
                /**
                 * index : 1
                 * desc : 适宜
                 * datetime : 2017-03-13
                 */

                private String index;
                private String desc;
                private String datetime;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }
            }

            public static class PrecipitationBeanX {
                /**
                 * date : 2017-03-13
                 * max : 0
                 * avg : 0
                 * min : 0
                 */

                private String date;
                private double max;
                private double avg;
                private double min;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(int max) {
                    this.max = max;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(int avg) {
                    this.avg = avg;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(int min) {
                    this.min = min;
                }
            }

            public static class WindBeanX {
                /**
                 * date : 2017-03-13
                 * max : {"direction":189.22,"speed":17.09}
                 * avg : {"direction":158.35,"speed":10.59}
                 * min : {"direction":141.91,"speed":6.43}
                 */

                private String date;
                private MaxBean max;
                private AvgBean avg;
                private MinBean min;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public MaxBean getMax() {
                    return max;
                }

                public void setMax(MaxBean max) {
                    this.max = max;
                }

                public AvgBean getAvg() {
                    return avg;
                }

                public void setAvg(AvgBean avg) {
                    this.avg = avg;
                }

                public MinBean getMin() {
                    return min;
                }

                public void setMin(MinBean min) {
                    this.min = min;
                }

                public static class MaxBean {
                    /**
                     * direction : 189.22
                     * speed : 17.09
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

                public static class AvgBean {
                    /**
                     * direction : 158.35
                     * speed : 10.59
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

                public static class MinBean {
                    /**
                     * direction : 141.91
                     * speed : 6.43
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
    }
}