(ns hububba.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [hububba.views :as views]))

(defroutes app-routes
  (GET "/" [] (views/index ["foo" "bar"]))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
