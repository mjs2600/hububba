(ns hububba.handler
  (:use compojure.core)
  (:require [clojure.edn :as edn]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [hububba.views :as views]
            [hububba.db :as db]))

(defroutes app-routes
  (GET "/" [] (views/index (db/all-posts)))
  (GET "/posts" [] (pr-str (db/all-posts)))
  (POST "/posts" [post] (do
                          (println (edn/read-string post))
                          (pr-str (db/all-posts))))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
