(defproject hububba "0.1.0-SNAPSHOT"
  :description "A chat/message board server"
  :url "https://github.com/mjs2600/hububba"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.4"]
                 [com.novemberain/monger "1.5.0"]]
  :plugins [[lein-ring "0.8.8"]]
  :ring {:handler hububba.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
