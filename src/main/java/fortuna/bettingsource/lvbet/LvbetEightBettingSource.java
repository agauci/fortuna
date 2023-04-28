package fortuna.bettingsource.lvbet;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.Bookmaker.LVBET;

@Builder
public class LvbetEightBettingSource extends BettingSource {

    private static List<BetOfferSource<?>> SOURCES =
            ImmutableList.<BetOfferSource<?>>builder()
                    .add(
                            /* ENGLAND */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37685")
                                    .description("PREMIER_LEAGUE")
                                    .eventCompetition(PREMIER_LEAGUE)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37558")
                                    .description("FA_CUP")
                                    .eventCompetition(FA_CUP)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37684")
                                    .description("CHAMPIONSHIP")
                                    .eventCompetition(CHAMPIONSHIP)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37555")
                                    .description("LEAGUE_ONE")
                                    .eventCompetition(LEAGUE_ONE)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37554")
                                    .description("LEAGUE_TWO")
                                    .eventCompetition(LEAGUE_TWO)
                                    .build(),

                            /* ITALY */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37680")
                                    .description("SERIE_A")
                                    .eventCompetition(SERIE_A)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37679")
                                    .description("SERIE_B")
                                    .eventCompetition(SERIE_B)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37655")
                                    .description("COPPA_ITALIA")
                                    .eventCompetition(COPPA_ITALIA)
                                    .build(),

                            /* EUROPE */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37660")
                                    .description("CHAMPIONS_LEAGUE")
                                    .eventCompetition(CHAMPIONS_LEAGUE)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37538")
                                    .description("EUROPA_LEAGUE")
                                    .eventCompetition(EUROPA_LEAGUE)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=68412")
                                    .description("CONFERENCE_LEAGUE")
                                    .eventCompetition(CONFERENCE_LEAGUE)
                                    .build(),

                            /* SPAIN */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=41533")
                                    .description("LA_LIGA")
                                    .eventCompetition(LA_LIGA)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37672")
                                    .description("LA_LIGA_2")
                                    .eventCompetition(LA_LIGA_2)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37371")
                                    .description("COPA_DEL_REY")
                                    .eventCompetition(COPA_DEL_REY)
                                    .build(),

                            /* FRANCE */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37677")
                                    .description("LIGUE_1")
                                    .eventCompetition(LIGUE_1)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37676")
                                    .description("LIGUE_2")
                                    .eventCompetition(LIGUE_2)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37528")
                                    .description("COUPE_DE_FRANCE")
                                    .eventCompetition(COUPE_DE_FRANCE)
                                    .build(),

                            /* GERMANY */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37682")
                                    .description("BUNDESLIGA")
                                    .eventCompetition(BUNDESLIGA)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37681")
                                    .description("BUNDESLIGA_2")
                                    .eventCompetition(BUNDESLIGA_2)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37523")
                                    .description("DFB_POKAL")
                                    .eventCompetition(DFB_POKAL)
                                    .build(),

                            /* TURKEY */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37353")
                                    .description("SUPER_LIG_TURKEY")
                                    .eventCompetition(SUPER_LIG_TURKEY)
                                    .build(),

                            /* PORTUGAL */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37666")
                                    .description("PRIMIERA_LIGA_PORTUGAL")
                                    .eventCompetition(PRIMIERA_LIGA_PORTUGAL)
                                    .build(),

                            /* NETHERLANDS */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37446")
                                    .description("EVERDISIE")
                                    .eventCompetition(EVERDISIE)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37445")
                                    .description("EERSTE_DIVISIE")
                                    .eventCompetition(EERSTE_DIVISIE)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37444")
                                    .description("KNVB_CUP")
                                    .eventCompetition(KNVB_CUP)
                                    .build()
                    )
                    .build();

    @Override
    public BettingSourceType getType() {
        return LVBET;
    }

    @Override
    public List<BetOfferSource<?>> sources() {
        return SOURCES;
    }
}
