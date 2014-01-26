(defproject hububba "0.1.0-SNAPSHOT"
  :description "A chat/message board server"
  :url "https://github.com/mjs2600/hububba"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2127"]
                 [compojure "1.1.6"]
                 [fogus/ring-edn "0.2.0"]
                 [hiccup "1.0.4"]
                 [com.novemberain/monger "1.5.0"]
                 [enfocus "2.0.2"]
                 [cljs-ajax "0.2.3"]]
  :plugins [[lein-ring "0.8.8"]
            [lein-cljsbuild "1.0.1"]]
  :ring {:handler hububba.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}}
  :cljsbuild
  {:builds
   [{:source-paths ["src-cljs"]
     :compiler
     {:output-dir "resources/public/js"
      :output-to "resources/public/js/app.js"
      :source-map-path "js"
      :source-map true
      :optimizations :none}}]})
