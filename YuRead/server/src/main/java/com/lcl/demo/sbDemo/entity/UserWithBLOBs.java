package com.lcl.demo.sbDemo.entity;

public class UserWithBLOBs extends User {
    private byte[] sslCipher;

    private byte[] x509Issuer;

    private byte[] x509Subject;

    private String authenticationString;

    public UserWithBLOBs(String user, String host, String password, String selectPriv, String insertPriv, String updatePriv, String deletePriv, String createPriv, String dropPriv, String reloadPriv, String shutdownPriv, String processPriv, String filePriv, String grantPriv, String referencesPriv, String indexPriv, String alterPriv, String showDbPriv, String superPriv, String createTmpTablePriv, String lockTablesPriv, String executePriv, String replSlavePriv, String replClientPriv, String createViewPriv, String showViewPriv, String createRoutinePriv, String alterRoutinePriv, String createUserPriv, String eventPriv, String triggerPriv, String createTablespacePriv, String sslType, Integer maxQuestions, Integer maxUpdates, Integer maxConnections, Integer maxUserConnections, String plugin, byte[] sslCipher, byte[] x509Issuer, byte[] x509Subject, String authenticationString) {
        super(user, host, password, selectPriv, insertPriv, updatePriv, deletePriv, createPriv, dropPriv, reloadPriv, shutdownPriv, processPriv, filePriv, grantPriv, referencesPriv, indexPriv, alterPriv, showDbPriv, superPriv, createTmpTablePriv, lockTablesPriv, executePriv, replSlavePriv, replClientPriv, createViewPriv, showViewPriv, createRoutinePriv, alterRoutinePriv, createUserPriv, eventPriv, triggerPriv, createTablespacePriv, sslType, maxQuestions, maxUpdates, maxConnections, maxUserConnections, plugin);
        this.sslCipher = sslCipher;
        this.x509Issuer = x509Issuer;
        this.x509Subject = x509Subject;
        this.authenticationString = authenticationString;
    }

    public UserWithBLOBs() {
        super();
    }

    public byte[] getSslCipher() {
        return sslCipher;
    }

    public void setSslCipher(byte[] sslCipher) {
        this.sslCipher = sslCipher;
    }

    public byte[] getX509Issuer() {
        return x509Issuer;
    }

    public void setX509Issuer(byte[] x509Issuer) {
        this.x509Issuer = x509Issuer;
    }

    public byte[] getX509Subject() {
        return x509Subject;
    }

    public void setX509Subject(byte[] x509Subject) {
        this.x509Subject = x509Subject;
    }

    public String getAuthenticationString() {
        return authenticationString;
    }

    public void setAuthenticationString(String authenticationString) {
        this.authenticationString = authenticationString == null ? null : authenticationString.trim();
    }
}