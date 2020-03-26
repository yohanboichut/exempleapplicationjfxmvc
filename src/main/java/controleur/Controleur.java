package controleur;

import javafx.stage.Stage;
import modele.FacadeAlexKiddBattle;
import modele.FacadeAlexKiddBattleImpl;
import modele.Score;
import modele.exceptions.ChoixIncompletsException;
import modele.exceptions.ChoixInnatenduException;
import modele.exceptions.PartieNonTermineeException;
import vues.VueAccueil;
import vues.VueCombat;
import vues.VueResultat;

public class Controleur {
    private FacadeAlexKiddBattle facadeAlexKiddBattle;
    private VueAccueil vueAccueil;
    private VueResultat vueResultat;
    private VueCombat vueCombat;

    private String choixAlexKidd;


    public Controleur(Stage stage) {
        facadeAlexKiddBattle = new FacadeAlexKiddBattleImpl();
        vueAccueil = VueAccueil.creer(stage);
        vueAccueil.initialiserControleur(this);
        vueResultat = VueResultat.creer(stage);
        vueResultat.initialiserControleur(this);
        vueCombat = VueCombat.creer(stage);
        vueCombat.initialiserControleur(this);
    }


    public void run() {
        vueAccueil.show();
    }


    public void connexion(String pseudoJoueur) {
        this.facadeAlexKiddBattle.setJoueur(pseudoJoueur);
        this.vueCombat.chargerDonnees();
        this.vueCombat.show();

    }

    public String getVainqueur() throws PartieNonTermineeException {
        return this.facadeAlexKiddBattle.getVainqueur();
    }

    public void goToMenu() {
        this.facadeAlexKiddBattle = new FacadeAlexKiddBattleImpl();
        this.vueAccueil.show();

    }

    public String getNomJoueur() {
        return facadeAlexKiddBattle.getNomJoueur();
    }

    public Score getScore() {
        return this.facadeAlexKiddBattle.getScore();
    }

    public void jouer(String choix) throws ChoixInnatenduException, ChoixIncompletsException {

        this.facadeAlexKiddBattle.setChoixCourantJoueur(choix);
        this.choixAlexKidd = this.facadeAlexKiddBattle.choixAlexKidd();
        this.facadeAlexKiddBattle.miseAJourResultat();
        this.vueCombat.majApresAlexKidd();
        if (this.facadeAlexKiddBattle.partieTerminee()) {
            this.vueResultat.chargerDonnees();
            this.vueResultat.show();
        }


    }

    public String getChoixAlexKidd() {
        return this.choixAlexKidd;
    }
}
