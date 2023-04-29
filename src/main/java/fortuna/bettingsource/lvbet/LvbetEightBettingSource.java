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
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37352")
                                    .eventCompetition(TURKEY_LEAGUE_2)
                                    .build(),

                            /* PORTUGAL */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37666")
                                    .description("PRIMIERA_LIGA_PORTUGAL")
                                    .eventCompetition(PRIMIERA_LIGA_PORTUGAL)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37665")
                                    .eventCompetition(PORTUGAL_LEAGUE_2)
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
                                    .build(),

                            /* AUSTRIA */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37669")
                                    .eventCompetition(AUSTRIA_LEAGUE_1)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37619")
                                    .eventCompetition(AUSTRIA_LEAGUE_2)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37618")
                                    .eventCompetition(AUSTRIA_OFB_CUP)
                                    .build(),

                            /* ARGENTINA */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=47145")
                                    .eventCompetition(ARGENTINA_LEAGUE_1)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=46437")
                                    .eventCompetition(ARGENTINA_LEAGUE_2)
                                    .build(),

                            /* BELGIUM */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37668")
                                    .eventCompetition(BELGIUM_FIRST_DIVISION_A_1)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37078")
                                    .eventCompetition(BELGIUM_FIRST_DIVISION_B_2)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37610")
                                    .eventCompetition(BELGIUM_CUP)
                                    .build(),

                            /* BULGARIA */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37593")
                                    .eventCompetition(BULGARIA_LEAGUE_1)
                                    .build(),
                            // TODO missing bulgaria league 2

                            /* BRAZIL */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37606")
                                    .eventCompetition(BRAZIL_LEAGUE_1)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37307")
                                    .eventCompetition(BRAZIL_LEAGUE_2)
                                    .build(),

                            /* CROATIA */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37576")
                                    .eventCompetition(CROATIA_LEAGUE_1)
                                    .build(),
                            // TODO missing croatia league 2

                            /* CYPRUS */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37573")
                                    .eventCompetition(CYPRUS_LEAGUE_1)
                                    .build(),

                            /* CZECH REPUBLIC */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37572")
                                    .eventCompetition(CZECH_REPUBLIC_LEAGUE_1)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37569")
                                    .eventCompetition(CZECH_REPUBLIC_LEAGUE_2)
                                    .build(),
                            // TODO missing czech republic cup

                            /* DENMARK */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37565")
                                    .eventCompetition(DENMARK_LEAGUE_1)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37568")
                                    .eventCompetition(DENMARK_LEAGUE_2)
                                    .build(),

                            /* GREECE */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=46435")
                                    .eventCompetition(GREECE_LEAGUE_1)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=46409")
                                    .eventCompetition(GREECE_LEAGUE_2)
                                    .build(),

                            /* IRELAND */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37418")
                                    .eventCompetition(IRELAND_LEAGUE_1)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37417")
                                    .eventCompetition(IRELAND_LEAGUE_2)
                                    .build(),

                            /* ISRAEL */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37491")
                                    .eventCompetition(ISRAEL_LEAGUE_1)
                                    .build(),

                            /* JAPAN */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37480")
                                    .eventCompetition(JAPAN_LEAGUE_1)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37479")
                                    .eventCompetition(JAPAN_LEAGUE_2)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=36970")
                                    .eventCompetition(JAPAN_LEAGUE_3)
                                    .build(),

                            /* MALTA */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37453")
                                    .eventCompetition(MALTA_CUP)
                                    .build(),

                            /* NORWAY */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37664")
                                    .eventCompetition(NORWAY_LEAGUE_1)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37436")
                                    .eventCompetition(NORWAY_LEAGUE_2)
                                    .build(),

                            /* POLAND */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37425")
                                    .eventCompetition(POLAND_LEAGUE_1)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37424")
                                    .eventCompetition(POLAND_LEAGUE_2)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37426")
                                    .eventCompetition(POLAND_CUP)
                                    .build(),

                            /* SCOTLAND */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37670")
                                    .eventCompetition(SCOTLAND_PREMIER_LEAGUE)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37673")
                                    .eventCompetition(SCOTLAND_CHAMPIONSHIP)
                                    .build(),
                            // TODO missing scottish league 1 and 2
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37388")
                                    .eventCompetition(SCOTLAND_FA_CUP)
                                    .build(),

                            /* SWEDEN */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37366")
                                    .eventCompetition(SWEDEN_LEAGUE_1)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37363")
                                    .eventCompetition(SWEDEN_LEAGUE_2)
                                    .build(),
                            // TODO missing sweden cup

                            /* SWITZERLAND */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37359")
                                    .eventCompetition(SWITZERLAND_SUPER_LEAGUE_1)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37360")
                                    .eventCompetition(SWITZERLAND_CHALLENGE_LEAGUE_2)
                                    .build(),
                            // TODO missing switzerland league 3

                            /* UKRAINE */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37346")
                                    .eventCompetition(UKRAINE_LEAGUE_1)
                                    .build(),

                            /* USA */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37341")
                                    .eventCompetition(MLS)
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
