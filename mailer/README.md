# Emailer  

This plugin provides a simple emailer.

## What new in this custom module?

- This plugin allow to add attachments to the mail

```
val mail = use[MailerPlugin].email
mail.addAttachment(new File("foo.txt")) // Attach file as 'foo.txt'
mail.addAttachment(new File("foo.txt"), Some("bar.txt")) // Attach file as 'bar.txt'
```

- Updated commons-email (1.2 -> 1.3)
- Updated documentation

## installation

**conf/Build.scala**

```
object ApplicationBuild extends Build {

  val appName         = "xxxxx"
  val appVersion      = "1.0-SNAPSHOT"

  val studiodevRepo = Seq(
    "Studiodev repository releases" at "http://studiodev.github.io/mvn-repo/releases",
    "Studiodev repository snapshot" at "http://studiodev.github.io/mvn-repo/snapshots"
  )

  val appDependencies = Seq(
    "fr.studio-dev"  %% "play-plugins-mailer" % "3.0.0"
  )

  val buildSettings = Defaults.defaultSettings ++ ScalaFormat.settings ++ Seq (
    resolvers ++= studiodevRepo
  )

  val main = play.Project(appName, appVersion, appDependencies, settings = buildSettings)

}
```

**conf/play.plugins**

Add ```1500:com.typesafe.plugin.CommonsMailerPlugin``` to your ```conf/play.plugins```

**conf/application.conf**

Configure the SMTP server:

```
smtp.host (mandatory)
smtp.port (defaults to 25)
smtp.ssl (defaults to no)
smtp.tls (defaults to no)
smtp.user (optional)
smtp.password (optional)
```

## using it from java 

```java
import com.typesafe.plugin.*;
MailerAPI mail = play.Play.application().plugin(MailerPlugin.class).email();
mail.setSubject("mailer");
mail.addRecipient("Peter Hausel Junior <noreply@email.com>","example@foo.com");
mail.addFrom("Peter Hausel <noreply@email.com>");
//sends html
mail.sendHtml("<html>html</html>" );
//sends text/text
mail.send( "text" );
//sends both text and html
mail.send( "text", "<html>html</html>");
```

## using it from scala

```scala
import com.typesafe.plugin._
val mail = use[MailerPlugin].email
mail.setSubject("mailer")
mail.addRecipient("Peter Hausel Junior <noreply@email.com>","example@foo.com")
mail.addFrom("Peter Hausel <noreply@email.com>")
//sends html
mail.sendHtml("<html>html</html>" )
//sends text/text
mail.send( "text" )
//sends both text and html
mail.send( "text", "<html>html</html>")
```

use[MailerPlugin] needs an implicit play.api.Application available to it.  If you do not have one available already from where you are trying to create the mailer you may want to add this line to get the current Application.

```scala
import play.api.Play.current
```

## Licence

This software is licensed under the Apache 2 license, quoted below.

Copyright 2012 Typesafe (http://www.typesafe.com).

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this project except in compliance with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
