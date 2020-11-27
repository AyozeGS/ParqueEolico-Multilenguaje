/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueeolicocliente;

import java.util.HashMap;

/**
 *
 * @author Ayo
 */
public class Code{
    
    public static HashMap<String,Integer> lenguajes = new HashMap<String,Integer>(){{
        put("es",0);
        put("en",1);
        put("fr",2);
    }};
    
    public static HashMap<String,String[]> mensajes = new HashMap<String,String[]>(){{
        //Excepciones
        put("ERROR401",new String[]{
            "Error al conectar con el servidor.",
            "Failed to connect to server.",
            "Échec de connexion au serveur."});
        put("ERROR402",new String[]{
            "Se ha producido un error. Sesión cancelada.",
            "An error has occurred. Session canceled.",
            "Une erreur est survenue. Session annulée."});
        
        //Atributos
        put("AEROGENERADOR",new String[]{
            "Aerogenerador",
            "Aerogenerator",
            "Aérogénérateur"});
        put("ESTADO",new String[]{
            "Estado",
            "Status",
            "Statut"});
        put("VELOCIDAD",new String[]{
            "Velocidad",
            "Speed",
            "La vitesse"});
        
        put("MSGMENU",new String[]{
            "Menú\n"
            + "<1> Relación de aerogeneradores\n"
            + "<2> Activar aerogenerador\n"
            + "<3> Desactivar aerogenerador\n"
            + "<4> Añadir aerogenerador\n"
            + "<5> Eliminar aerogenerador\n"
            + "<0> Salir\n"
            + "Selecciona una opción >> ",
            "Menu\n"
            + "<1> List of aerogenerators\n"
            + "<2> Activate aerogenerator\n"
            + "<3> Disable aerogenerator\n"
            + "<4> Add aerogenerator\n"
            + "<5> Delete aerogenerator\n"
            + "<0> Exit\n"
            + "Select an option >> ",
            "Menu\n"
            + "<1> Liste des aérogénérateurs\n"
            + "<2> Activer l'aérogénérateur\n"
            + "<3> Désactiver l'aérogénérateur\n"
            + "<4> Ajouter un aérogénérateur\n"
            + "<5> Supprimer l'aérogénérateur\n"
            + "<0> Sortie\n"
            + "Sélectionner une option >> "});
        put("MSGCLIST",new String[]{
            "\n---------------------------------------------------------\n"
            + "-              Relación de aerogeneradores              -\n"
            + "---------------------------------------------------------\n",
            "\n-----------------------------------------------------\n"
            + "-               List of wind turbines               -\n"
            + "-----------------------------------------------------\n",
            "\n-----------------------------------------------------------\n"
            + "-                   Liste des éoliennes                   -\n"
            + "-----------------------------------------------------------\n",});
        put("MSGC001",new String[]{
            "Escribe tu nombre para comenzar: ",
            "Write your name to start: ",
            "Écrivez votre nom pour commencer: "});
        put("MSGC100",new String[]{
            "La sesión ha finalizado.",
            "The session has ended.",
            "La session est terminée."});
        put("MSGC101",new String[]{
            "Número total de aerogeneradores: ",
            "Total number of wind turbines: ",
            "Nombre total d'éoliennes: "});
        put("MSGC102",new String[]{
            "Indica el aerogenerador a activar >> ",
            "Indicates the wind turbine to activate >> ",
            "Indique l'éolienne à activer >> "});
        put("MSGC103",new String[]{
            "Indica el aerogenerador a desactivar >> ",
            "Indicates the wind turbine to deactivate >> ",
            "Indique l'éolienne à désactiver >> "});
        put("MSGC104",new String[]{
            "Indica el nuevo id >> ",
            "Indicate the new id >> ",
            "Indiquez le nouvel identifiant >> "});
        put("MSGC105",new String[]{
            "Indica el aerogenerador a eliminar >> ",
            "Indicates the wind turbine to eliminate >> ",
            "Indique l'éolienne à éliminer >> "});
        put("MSGC199",new String[]{
            "Opción incorrecta\n",
            "Wrong option\n",
            "Mauvaise option\n"});
        
        //Mensajes del Servidor
        put("MSGS102",new String[]{
            "Aerogenerador activado\n",
            "Activated wind turbine\n",
            "Éolienne activée\n"});
        put("MSGS103",new String[]{
            "Aerogenerador desactivado\n",
            "Wind turbine deactivated\n",
            "Éolienne désactivée\n"});
        put("MSGS104",new String[]{
            "Aerogenerador añadido\n",
            "Wind turbine added\n",
            "Éolienne ajoutée\n"});
        put("MSGS105",new String[]{
            "Aerogenerador eliminado\n",
            "Wind turbine removed\n",
            "Éolienne retirée\n"});
        
        //Avisos del Servidor
        put("WNGS400",new String[]{
            "Identificación no válida\n",
            "Invalid id\n",
            "ID invalide\n"});
        put("WNGS401",new String[]{
            "No existe el aerogenerador\n",
            "That wind turbine does not exist\n",
            "Cette éolienne n'existe pas\n"});
        put("WNGS402",new String[]{
            "El aerogenerador ya está activo\n",
            "The wind turbine is already active\n",
            "L'éolienne est déjà active\n"});
        put("WNGS403",new String[]{
            "El aerogenerador no está activo\n",
            "The wind turbine is not active\n",
            "L'éolienne n'est pas active\n"});
        put("WNGS404",new String[]{
            "Ya existe aerogenerador con esa identificación\n",
            "There is already a wind turbine with that identification\n",
            "Il y a déjà une éolienne avec cette identification\n"});
    }};      
}
