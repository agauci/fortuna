package fortuna.bettingsource.stake;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.Bookmaker.STAKE;

@Builder
public class StakeBettingSource extends BettingSource {

    private static List<BetOfferSource<?>> SOURCES =
                ImmutableList.<BetOfferSource<?>>builder()
                        .add(
                            /* EUROPE */
                            StakeThreeWayBetOfferSource.builder()
                                    .url("https://stake.com/sports/soccer/international-clubs/uefa-champions-league")
                                    .eventCompetition(CHAMPIONS_LEAGUE)
                                    .build(),
                            StakeThreeWayBetOfferSource.builder()
                                    .url("https://stake.com/sports/soccer/international-clubs/uefa-europa-league")
                                    .eventCompetition(EUROPA_LEAGUE)
                                    .build(),
                            StakeThreeWayBetOfferSource.builder()
                                    .url("https://stake.com/sports/soccer/international-clubs/uefa-europa-conference-league")
                                    .eventCompetition(CONFERENCE_LEAGUE)
                                    .build(),

                                /* ARGENTINA */
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/argentina/superliga")
                                        .eventCompetition(ARGENTINA_LEAGUE_1)
                                        .build(),
                                // TODO missing argentina league 2

                            /* AUSTRIA */
                            StakeThreeWayBetOfferSource.builder()
                                    .url("https://stake.com/sports/soccer/austria/bundesliga")
                                    .eventCompetition(AUSTRIA_LEAGUE_1)
                                    .build(),
                            StakeThreeWayBetOfferSource.builder()
                                    .url("https://stake.com/sports/soccer/austria/2-liga")
                                    .eventCompetition(AUSTRIA_LEAGUE_2)
                                    .build(),
                            // TODO missing austria cup

                                /* BELGIUM */
                                // TODO missing belgium league 1
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/belgium/first-division-b")
                                        .eventCompetition(BELGIUM_FIRST_DIVISION_B_2)
                                        .build(),
                                // todo missing belgium cup

                                /* BRAZIL */
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/brazil/brasileiro-serie-a")
                                        .eventCompetition(BRAZIL_LEAGUE_1)
                                        .build(),
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/brazil/brasileiro-serie-b")
                                        .eventCompetition(BRAZIL_LEAGUE_2)
                                        .build(),

                                /* BULGARIA */
                                // TODO missing bulgaria league 1, 2

                                /* CROATIA */
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/croatia/1-hnl")
                                        .eventCompetition(CROATIA_LEAGUE_1)
                                        .build(),
                                // TODO missing croatia league 2

                                /* CYPRUS */
                                // TODO missing cyprus league 1

                                /* CZECH REPUBLIC */
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/czech-republic/1-liga")
                                        .eventCompetition(CZECH_REPUBLIC_LEAGUE_1)
                                        .build(),
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/czech-republic/fnl")
                                        .eventCompetition(CZECH_REPUBLIC_LEAGUE_2)
                                        .build(),

                                /* DENMARK */
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/denmark/superligaen")
                                        .eventCompetition(DENMARK_LEAGUE_1)
                                        .build(),
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/denmark/1st-division")
                                        .eventCompetition(DENMARK_LEAGUE_2)
                                        .build(),
                                // TODO missing denmark cup

                                /* ENGLAND */
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/england/premier-league")
                                        .eventCompetition(PREMIER_LEAGUE)
                                        .build(),
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/england/championship")
                                        .eventCompetition(CHAMPIONSHIP)
                                        .build(),
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/england/fa-cup")
                                        .eventCompetition(FA_CUP)
                                        .build(),
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/england/league-one")
                                        .eventCompetition(LEAGUE_ONE)
                                        .build(),
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/england/league-two")
                                        .eventCompetition(LEAGUE_TWO)
                                        .build(),

                                /* FRANCE */
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/france/ligue-1")
                                        .eventCompetition(LIGUE_1)
                                        .build(),
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/france/ligue-2")
                                        .eventCompetition(LIGUE_2)
                                        .build(),
                                // TODO missing france cup

                                /* GERMANY */
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/germany/bundesliga")
                                        .eventCompetition(BUNDESLIGA)
                                        .build(),
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/germany/dfb-pokal")
                                        .eventCompetition(BUNDESLIGA_2)
                                        .build(),
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/germany/2nd-bundesliga")
                                        .eventCompetition(DFB_POKAL)
                                        .build(),

                                /* GREECE */
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/greece/super-league-1")
                                        .eventCompetition(GREECE_LEAGUE_1)
                                        .build(),
                               // TODO missing greece league 2

                                /* IRELAND */
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/ireland/premier-division")
                                        .eventCompetition(IRELAND_LEAGUE_1)
                                        .build(),
                                // TODO missing ireland league 2

                                /* ISRAEL */
                                // TODO missing israel league 1

                                /* ITALY */
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/italy/serie-a")
                                        .eventCompetition(SERIE_A)
                                        .build(),
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/italy/serie-b")
                                        .eventCompetition(SERIE_B)
                                        .build(),
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/italy/coppa-italia")
                                        .eventCompetition(COPPA_ITALIA)
                                        .build(),

                                /* JAPAN */
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/japan/j-league")
                                        .eventCompetition(JAPAN_LEAGUE_1)
                                        .build(),
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/japan/j-league-2")
                                        .eventCompetition(JAPAN_LEAGUE_2)
                                        .build(),
                                // TODO missing Japan league 3

                                /* MALTA */
                                // Missing Malta Cup

                                /* NETHERLANDS */
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/netherlands/eredivisie")
                                        .eventCompetition(EVERDISIE)
                                        .build(),
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/netherlands/eerste-divisie")
                                        .eventCompetition(EERSTE_DIVISIE)
                                        .build(),
                                // TODO missing netherlands cup

                                /* NORWAY */
                                // TODO missing norawy league 1, 2

                                /* POLAND */
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/poland/ekstraklasa")
                                        .eventCompetition(POLAND_LEAGUE_1)
                                        .build(),
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/poland/i-liga")
                                        .eventCompetition(POLAND_LEAGUE_2)
                                        .build(),
                                // TODO missing poland cup

                                /* PORTUGAL */
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/portugal/primeira-liga")
                                        .eventCompetition(PRIMIERA_LIGA_PORTUGAL)
                                        .build(),
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/portugal/segunda-liga")
                                        .eventCompetition(PORTUGAL_LEAGUE_2)
                                        .build(),
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/portugal/taca-de-portugal")
                                        .eventCompetition(PORTUGAL_CUP)
                                        .build(),

                                /* SCOTLAND */
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/scotland/premiership")
                                        .eventCompetition(SCOTLAND_PREMIER_LEAGUE)
                                        .build(),
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/scotland/championship")
                                        .eventCompetition(SCOTLAND_CHAMPIONSHIP)
                                        .build(),
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/scotland/league-two")
                                        .eventCompetition(SCOTLAND_LEAGUE_TWO)
                                        .build(),
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/scotland/scottish-cup")
                                        .eventCompetition(SCOTLAND_FA_CUP)
                                        .build(),
                                // TODO missing scotland league 1

                                /* SPAIN */
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/spain/la-liga")
                                        .eventCompetition(LA_LIGA)
                                        .build(),
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/spain/la-liga-2")
                                        .eventCompetition(LA_LIGA_2)
                                        .build(),
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/spain/copa-del-rey")
                                        .eventCompetition(COPA_DEL_REY)
                                        .build(),

                                /* SWEDEN */
                                // TODO missing sweden league 1, 2, cup

                                /* SWITZERLAND */
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/switzerland/super-league")
                                        .eventCompetition(SWITZERLAND_SUPER_LEAGUE_1)
                                        .build(),
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/switzerland/challenge-league")
                                        .eventCompetition(SWITZERLAND_CHALLENGE_LEAGUE_2)
                                        .build(),
                                // TODO missing switzerland promotion league

                                /* TURKEY */
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/turkey/super-lig")
                                        .eventCompetition(SUPER_LIG_TURKEY)
                                        .build(),
                                // TODO missing turkey league 2, cup

                                /* UKRAINE */
                                // TODO missing ukraine league 1

                                /* USA */
                                StakeThreeWayBetOfferSource.builder()
                                        .url("https://stake.com/sports/soccer/usa/major-league-soccer")
                                        .eventCompetition(MLS)
                                        .build()

                        )
                    .build();

    @Override
    public BettingSourceType getType() {
        return STAKE;
    }

    @Override
    public List<BetOfferSource<?>> sources() {
        return SOURCES;
    }
}
