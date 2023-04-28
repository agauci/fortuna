package fortuna.bettingsource.ejjabet;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.Bookmaker.IZIBET;

@Builder
public class EjjabetBettingSource extends BettingSource {

    private static List<BetOfferSource<?>> SOURCES =
                ImmutableList.<BetOfferSource<?>>builder()
                        .add(
                            /* ENGLAND */
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22057336&region=2570001&competition=538&sport=1")
                                    .description("PREMIER_LEAGUE")
                                    .eventCompetition(PREMIER_LEAGUE)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&region=2570001&competition=1840&sport=1")
                                    .description("FA_CUP")
                                    .eventCompetition(FA_CUP)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&region=2570001&competition=539&sport=1")
                                    .description("CHAMPIONSHIP")
                                    .eventCompetition(CHAMPIONSHIP)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&region=2570001&competition=1843&sport=1")
                                    .description("LEAGUE_ONE")
                                    .eventCompetition(LEAGUE_ONE)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&region=2570001&competition=1844&sport=1")
                                    .description("LEAGUE_TWO")
                                    .eventCompetition(LEAGUE_TWO)
                                    .build(),

                            /* ITALY */
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=543&sport=1&region=1170001")
                                    .description("SERIE_A")
                                    .eventCompetition(SERIE_A)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=544&sport=1&region=1170001")
                                    .description("SERIE_B")
                                    .eventCompetition(SERIE_B)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=572&sport=1&region=1170001")
                                    .description("COPPA_ITALIA")
                                    .eventCompetition(COPPA_ITALIA)
                                    .build(),

                            /* EUROPE */
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=566&sport=1&region=20001")
                                    .description("CHAMPIONS_LEAGUE")
                                    .eventCompetition(CHAMPIONS_LEAGUE)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=1861&sport=1&region=20001")
                                    .description("EUROPA_LEAGUE")
                                    .eventCompetition(EUROPA_LEAGUE)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=18278410&sport=1&region=20001")
                                    .description("CONFERENCE_LEAGUE")
                                    .eventCompetition(CONFERENCE_LEAGUE)
                                    .build(),

                            /* SPAIN */
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=545&sport=1&region=2150001")
                                    .description("LA_LIGA")
                                    .eventCompetition(LA_LIGA)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=553&sport=1&region=2150001")
                                    .description("LA_LIGA_2")
                                    .eventCompetition(LA_LIGA_2)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=2991&sport=1&region=2150001")
                                    .description("COPA_DEL_REY")
                                    .eventCompetition(COPA_DEL_REY)
                                    .build(),

                            /* FRANCE */
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=548&sport=1&region=830001")
                                    .description("LIGUE_1")
                                    .eventCompetition(LIGUE_1)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=549&sport=1&region=830001")
                                    .description("LIGUE_2")
                                    .eventCompetition(LIGUE_2)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=1871&sport=1&region=830001")
                                    .description("COUPE_DE_FRANCE")
                                    .eventCompetition(COUPE_DE_FRANCE)
                                    .build(),

                            /* GERMANY */
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=541&sport=1&region=900001")
                                    .description("BUNDESLIGA")
                                    .eventCompetition(BUNDESLIGA)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=542&sport=1&region=900001")
                                    .description("BUNDESLIGA_2")
                                    .eventCompetition(BUNDESLIGA_2)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=1876&sport=1&region=900001")
                                    .description("DFB_POKAL")
                                    .eventCompetition(DFB_POKAL)
                                    .build(),

                            /* TURKEY */
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=3013&sport=1&region=2340001")
                                    .description("SUPER_LIG_TURKEY")
                                    .eventCompetition(SUPER_LIG_TURKEY)
                                    .build(),

                            /* PORTUGAL */
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=560&sport=1&region=1850001")
                                    .description("PRIMIERA_LIGA_PORTUGAL")
                                    .eventCompetition(PRIMIERA_LIGA_PORTUGAL)
                                    .build(),

                            /* NETHERLANDS */
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=1957&sport=1&region=1640001")
                                    .description("EVERDISIE")
                                    .eventCompetition(EVERDISIE)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=1958&sport=1&region=1640001")
                                    .description("EERSTE_DIVISIE")
                                    .eventCompetition(EERSTE_DIVISIE)
                                    .build(),
                            EjjabetThreeWayBetOfferSource.builder()
                                    .url("https://sportsbookweb.casino-pp.net/#/sport/?type=0&game=22101285&competition=1959&sport=1&region=1640001")
                                    .description("KNVB_CUP")
                                    .eventCompetition(KNVB_CUP)
                                    .build()
                    )
                    .build();

    @Override
    public BettingSourceType getType() {
        return IZIBET;
    }

    @Override
    public List<BetOfferSource<?>> sources() {
        return SOURCES;
    }
}
