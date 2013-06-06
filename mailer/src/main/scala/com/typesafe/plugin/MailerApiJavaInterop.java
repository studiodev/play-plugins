package com.typesafe.plugin;

import scala.Option;
import java.io.File;

public interface MailerApiJavaInterop {

    /**
    * Sets a subject for this email. It enables formatting of the providing string using Java's
    * string formatter.
    *
    * @param subject
    * @param args
    */
    public MailerAPI setSubject(String subject, java.lang.Object... args);

    /**
    * Adds an email recipient in CC.
    *
    * @param ccRecipients
    */
    public MailerAPI addCc(String... ccRecipients);

    /**
    * Adds an email recipient in BCC.
    *
    * @param bccRecipients
    */
    public MailerAPI addBcc(String... bccRecipients);

    /**
    * Adds an email recipient ("to" addressee).
    *
    * @param recipients
    */
    public MailerAPI addRecipient(String... recipients);

    /**
     * Add an attachment to the mail
     * @param file File to add
     */
    public MailerAPI addAttachment(File file, Option<String> name);

}
