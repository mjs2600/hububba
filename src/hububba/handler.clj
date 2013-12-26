(ns hububba.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [hububba.views :as views]
            [hububba.db :as db]))

(defroutes app-routes
  (GET "/" [] (views/index (db/all-posts) ))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
