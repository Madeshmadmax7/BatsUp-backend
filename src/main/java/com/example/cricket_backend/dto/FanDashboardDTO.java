// com/example/cricket_backend/dto/FanDashboardDTO.java
package com.example.cricket_backend.dto;

import java.util.List;
import com.example.cricket_backend.model.NewsLetter;
import com.example.cricket_backend.model.Match;

public class FanDashboardDTO {
    private List<NewsLetter> followedTeamNews;
    private List<NewsLetter> otherNews;
    private List<Match> followedTeamMatches;

    public FanDashboardDTO() {}

    public FanDashboardDTO(List<NewsLetter> followedTeamNews, List<NewsLetter> otherNews, List<Match> followedTeamMatches) {
        this.followedTeamNews = followedTeamNews;
        this.otherNews = otherNews;
        this.followedTeamMatches = followedTeamMatches;
    }

    public List<NewsLetter> getFollowedTeamNews() { return followedTeamNews; }
    public void setFollowedTeamNews(List<NewsLetter> followedTeamNews) { this.followedTeamNews = followedTeamNews; }

    public List<NewsLetter> getOtherNews() { return otherNews; }
    public void setOtherNews(List<NewsLetter> otherNews) { this.otherNews = otherNews; }

    public List<Match> getFollowedTeamMatches() { return followedTeamMatches; }
    public void setFollowedTeamMatches(List<Match> followedTeamMatches) { this.followedTeamMatches = followedTeamMatches; }
}
