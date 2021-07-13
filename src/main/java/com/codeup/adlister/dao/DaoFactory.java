
package com.codeup.adlister.dao;

public class DaoFactory {
    private static Ads adsDao;
    private static Users usersDao;
    private static Config config = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }
}

//package com.codeup.adlister.dao;
//
//public class DaoFactory {
//    private static Ads adsDao;
//    private static Users usersDao;
//    private static Config config = new Config();
//    private static Users userDao;
//
//    public static Ads getAdsDao() {
//        if (adsDao == null) {
//            adsDao = new MySQLAdsDao(config);
//        }
//        return adsDao;
//    }
//
//    public static Users getUserDao() {
//        if (userDao == null) {
//            userDao = (Users) new MySQLUsersDao(config);
//        }
//        return userDao;
//    }
//}
