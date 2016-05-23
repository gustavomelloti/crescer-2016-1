﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using CdZ.MVC.CustomModelBinders.CdZ.MVC.CustomModelBinders;
using System.Web.Mvc;
using System.Web.Routing;


namespace CdZ.MVC
{
    public class MvcApplication : System.Web.HttpApplication
    {
        protected void Application_Start()
        {
            AreaRegistration.RegisterAllAreas();
            RouteConfig.RegisterRoutes(RouteTable.Routes);
            ModelBinders.Binders.Add(typeof(double), new DoubleModelBinder());
            ModelBinders.Binders.Add(typeof(double?), new DoubleModelBinder());
        }
    }
}
