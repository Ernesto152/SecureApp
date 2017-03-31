package app.ernestochira.com.secureapp.models;

import java.util.ArrayList;
import java.util.List;

import app.ernestochira.com.secureapp.R;

/**
 * Created by usuario on 29/03/2017.
 */

public class NewsService {
    private List<News> news;

    public NewsService() {
        news = new ArrayList<>();
        //incidencias
        news.add(new News("ERNESTO CHIRA TORRES", "Robo"
                , "Robo en la Av. Arequipa cdra. 2, exactamente a la espalda de la UTP"
                ,"29/03/2017","13:56", Integer.toString(R.mipmap.ic_launcher)));
        news.add(new News("ERNESTO CHIRA TORRES", "Robo"
                , "Robo en la Av. Arequipa cdra. 2, exactamente a la espalda de la UTP"
                ,"29/03/2017","13:56", Integer.toString(R.mipmap.ic_launcher)));
        news.add(new News("ERNESTO CHIRA TORRES", "Robo"
                , "Robo en la Av. Arequipa cdra. 2, exactamente a la espalda de la UTP"
                ,"29/03/2017","13:56", Integer.toString(R.mipmap.ic_launcher)));
        news.add(new News("ERNESTO CHIRA TORRES", "Robo"
                , "Robo en la Av. Arequipa cdra. 2, exactamente a la espalda de la UTP"
                ,"29/03/2017","13:56", Integer.toString(R.mipmap.ic_launcher)));
        news.add(new News("ERNESTO CHIRA TORRES", "Robo"
                , "Robo en la Av. Arequipa cdra. 2, exactamente a la espalda de la UTP"
                ,"29/03/2017","13:56", Integer.toString(R.mipmap.ic_launcher)));
        news.add(new News("ERNESTO CHIRA TORRES", "Robo"
                , "Robo en la Av. Arequipa cdra. 2, exactamente a la espalda de la UTP"
                ,"29/03/2017","13:56", Integer.toString(R.mipmap.ic_launcher)));
        news.add(new News("ERNESTO CHIRA TORRES", "Robo"
                , "Robo en la Av. Arequipa cdra. 2, exactamente a la espalda de la UTP"
                ,"29/03/2017","13:56", Integer.toString(R.mipmap.ic_launcher)));
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}
