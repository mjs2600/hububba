(ns hububba.handler
  (:use compojure.core)
  (:use ring.middleware.edn)
  (:require [clojure.edn :as edn]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [hububba.views :as views]
            [hububba.db :as db]))

(defn edn-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/edn"}
   :body (pr-str data)})

(defroutes app-routes
  (GET "/" [] (views/index (db/all-posts)))
  (GET "/posts" [] (edn-response (db/all-posts)))
  (POST "/posts" {params :params} (db/new-post params) (edn-response (db/all-posts)))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (wrap-edn-params (handler/site app-routes)))
