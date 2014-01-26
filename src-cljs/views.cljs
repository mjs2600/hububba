(ns hububba.views
  (:require [enfocus.core :as ef]
            [enfocus.events :as events]
            [enfocus.effects :as effects]
            [hububba.posts :as posts])
  (:require-macros [enfocus.macros :as em]))

(defn add-post [post]
  (ef/at js/document
         ["div#posts"] (ef/prepend (ef/html [:dl [:dt (:title post)]
                                          [:dd (:content post)]]))))

(defn add-posts [posts]
  (do (ef/at js/document ["div#posts"] (ef/content nil))
      (doseq [post posts] (add-post post))))

(defn get-new-post []
  (ef/from "#post-form" (ef/read-form)))

(defn create-post []
  (posts/create-post (pr-str (get-new-post))))

(em/defaction create-posts []
  ["#new-post"] (events/listen :click #(do (create-post) false)))
