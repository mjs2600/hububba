(ns hububba.posts
  (:require [ajax.core :refer [GET POST]]
            [hububba.views :as views]))

(defn render-posts [content]
  (.log js/console (str content))
  (views/add-posts content))

(defn all-posts []
  (.log js/console "Getting posts")
  (GET "/posts"
       {:handler render-posts}))

(defn create-post [post]
  (do (.log js/console (pr-str post))
      (POST "/posts"
            {:params post
             :handler render-posts})))
