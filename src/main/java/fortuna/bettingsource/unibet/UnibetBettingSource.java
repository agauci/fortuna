package fortuna.bettingsource.unibet;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.Bookmaker.UNIBET;
@Builder
public class UnibetBettingSource extends BettingSource {

    private static List<BetOfferSource<?>> SOURCES =
            ImmutableList.<BetOfferSource<?>>builder()
                    .add(
                            /* EUROPE */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/champions_league/all/matches")
                                    .description("CHAMPIONS_LEAGUE")
                                    .eventCompetition(CHAMPIONS_LEAGUE)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/europa_league/all/matches")
                                    .description("EUROPA_LEAGUE")
                                    .eventCompetition(EUROPA_LEAGUE)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/europa_conference_league/all/matches")
                                    .description("CONFERENCE_LEAGUE")
                                    .eventCompetition(CONFERENCE_LEAGUE)
                                    .build(),

                            /* ENGLAND */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/england/premier_league/all/matches")
                                    .description("PREMIER_LEAGUE")
                                    .eventCompetition(PREMIER_LEAGUE)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/england/fa_cup/all/matches")
                                    .description("FA_CUP")
                                    .eventCompetition(FA_CUP)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/england/the_championship/all/matches")
                                    .description("CHAMPIONSHIP")
                                    .eventCompetition(CHAMPIONSHIP)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/england/league_one/all/matches")
                                    .description("LEAGUE_ONE")
                                    .eventCompetition(LEAGUE_ONE)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/england/league_two/all/matches")
                                    .description("LEAGUE_TWO")
                                    .eventCompetition(LEAGUE_TWO)
                                    .build(),

                            /* ITALY */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/italy/serie_a/all/matches")
                                    .description("SERIE_A")
                                    .eventCompetition(SERIE_A)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/italy/serie_b/all/matches")
                                    .description("SERIE_B")
                                    .eventCompetition(SERIE_B)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/italy/coppa_italia/all/matches")
                                    .description("COPPA_ITALIA")
                                    .eventCompetition(COPPA_ITALIA)
                                    .build(),

                            /* SPAIN */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/spain/la_liga/all/matches")
                                    .description("LA_LIGA")
                                    .eventCompetition(LA_LIGA)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/spain/la_liga_2/all/matches")
                                    .description("LA_LIGA_2")
                                    .eventCompetition(LA_LIGA_2)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/spain/copa_del_rey/all/matches")
                                    .description("COPA_DEL_REY")
                                    .eventCompetition(COPA_DEL_REY)
                                    .build(),

                            /* FRANCE */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/france/ligue_1/all/matches")
                                    .description("LIGUE_1")
                                    .eventCompetition(LIGUE_1)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/france/ligue_2/all/matches")
                                    .description("LIGUE_2")
                                    .eventCompetition(LIGUE_2)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/france/coupe_de_france/all/matches")
                                    .description("COUPE_DE_FRANCE")
                                    .eventCompetition(COUPE_DE_FRANCE)
                                    .build(),

                            /* GERMANY */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/germany/bundesliga/all/matches")
                                    .description("BUNDESLIGA")
                                    .eventCompetition(BUNDESLIGA)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/germany/2__bundesliga/all/matches")
                                    .description("BUNDESLIGA_2")
                                    .eventCompetition(BUNDESLIGA_2)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/germany/dfb_pokal/all/matches")
                                    .description("DFB_POKAL")
                                    .eventCompetition(DFB_POKAL)
                                    .build(),

                            /* TURKEY */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/turkey/super_lig/all/matches")
                                    .description("SUPER_LIG_TURKEY")
                                    .eventCompetition(SUPER_LIG_TURKEY)
                                    .build(),

                            /* PORTUGAL */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/portugal/primeira_liga/all/matches")
                                    .description("PRIMIERA_LIGA_PORTUGAL")
                                    .eventCompetition(PRIMIERA_LIGA_PORTUGAL)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/portugal/ligapro/all/matches")
                                    .eventCompetition(PORTUGAL_LEAGUE_2)
                                    .build(),

                            /* NETHERLANDS */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/netherlands/eredivisie/all/matches")
                                    .description("EVERDISIE")
                                    .eventCompetition(EVERDISIE)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/netherlands/eerste_divisie/all/matches")
                                    .description("EERSTE_DIVISIE")
                                    .eventCompetition(EERSTE_DIVISIE)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/netherlands/knvb_beker/all/matches")
                                    .description("KNVB_CUP")
                                    .eventCompetition(KNVB_CUP)
                                    .build(),

                            /* AUSTRIA */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/austria/bundesliga/all/matches")
                                    .eventCompetition(AUSTRIA_LEAGUE_1)
                                    .build(),
                            // TODO missing austria league 2, cup

                            /* ARGENTINA */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/argentina/liga_profesional_argentina/all/matches")
                                    .eventCompetition(ARGENTINA_LEAGUE_1)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/argentina/primera_b_nacional/all/matches")
                                    .eventCompetition(ARGENTINA_LEAGUE_2)
                                    .build(),

                            /* BELGIUM */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/belgium/jupiler_pro_league/all/matches")
                                    .eventCompetition(BELGIUM_FIRST_DIVISION_A_1)
                                    .build(),
                            // TODO missing belgium league 2
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/belgium/beker_van_belgie/all/matches")
                                    .eventCompetition(BELGIUM_CUP)
                                    .build(),

                            /* BULGARIA */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/bulgaria/pfl_1/all/matches")
                                    .eventCompetition(BULGARIA_LEAGUE_1)
                                    .build(),
                            // TODO missing bulgaria league 2

                            /* BRAZIL */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/brazil/brasileirao_serie_a/all/matches")
                                    .eventCompetition(BRAZIL_LEAGUE_1)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/brazil/brasileirao_serie_b/all/matches")
                                    .eventCompetition(BRAZIL_LEAGUE_2)
                                    .build(),

                            /* CROATIA */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/croatia/1__hnl_league/all/matches")
                                    .eventCompetition(CROATIA_LEAGUE_1)
                                    .build(),
                            // TODO missing croatia league 2

                            /* CYPRUS */
                            // TODO missing cyprus league 1

                            /* CZECH REPUBLIC */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/czech_republic/first_league/all/matchesa")
                                    .eventCompetition(CZECH_REPUBLIC_LEAGUE_1)
                                    .build(),
                            // TODO missing czech republic league 2, cup

                            /* DENMARK */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/denmark/superligaen/all/matches")
                                    .eventCompetition(DENMARK_LEAGUE_1)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/denmark/1st_division/all/matches")
                                    .eventCompetition(DENMARK_LEAGUE_2)
                                    .build(),

                            /* GREECE */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/greece/super_league/all/matches")
                                    .eventCompetition(GREECE_LEAGUE_1)
                                    .build(),
                            // TODO missing greece league 2

                            /* IRELAND */
                            // TODO missing ireland league 1, 2

                            /* ISRAEL */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/israel/ligat_ha_al/all/matches")
                                    .eventCompetition(ISRAEL_LEAGUE_1)
                                    .build(),

                            /* JAPAN */
                            // TODO missing japan j1
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/japan/j2-league")
                                    .eventCompetition(JAPAN_LEAGUE_2)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/japan/j3-league/all/matches")
                                    .eventCompetition(JAPAN_LEAGUE_3)
                                    .build(),

                            /* MALTA */
                            // TODO missing malta cup

                            /* NORWAY */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/norway/eliteserien/all/matches")
                                    .eventCompetition(NORWAY_LEAGUE_1)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/norway/obos-ligaen/all/matches")
                                    .eventCompetition(NORWAY_LEAGUE_2)
                                    .build(),

                            /* POLAND */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/poland/ekstraklasa/all/matches")
                                    .eventCompetition(POLAND_LEAGUE_1)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/poland/i_liga/all/matches")
                                    .eventCompetition(POLAND_LEAGUE_2)
                                    .build(),
                            // TODO missing poland cup

                            /* SCOTLAND */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/scotland/scottish_premiership/all/competitions")
                                    .eventCompetition(SCOTLAND_PREMIER_LEAGUE)
                                    .build(),
                            // TODO missing scottish champtionship, league 1 and 2
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/scotland/scottish_cup/all/matches")
                                    .eventCompetition(SCOTLAND_FA_CUP)
                                    .build(),

                            /* SWEDEN */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/sweden/allsvenskan/all/matches")
                                    .eventCompetition(SWEDEN_LEAGUE_1)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/sweden/superettan/all/matches")
                                    .eventCompetition(SWEDEN_LEAGUE_2)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/sweden/svenska_cupen/all/matches")
                                    .eventCompetition(SWEDEN_CUP)
                                    .build(),

                            /* SWITZERLAND */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/switzerland/super_league/all/matches")
                                    .eventCompetition(SWITZERLAND_SUPER_LEAGUE_1)
                                    .build(),
                            // TODO missing switzerland league 2, 3

                            /* UKRAINE */
                            // TODO missing ukraine league 1

                            /* USA */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/usa/mls/all/matches")
                                    .eventCompetition(MLS)
                                    .build()
                    )
                    .build();

    @Override
    public BettingSourceType getType() {
        return UNIBET;
    }

    @Override
    public List<BetOfferSource<?>> sources() {
        return SOURCES;
    }
}
