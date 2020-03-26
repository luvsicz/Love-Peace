import {getRequest} from './api'

export const initMenu = (router, store) => {
  //长度大于0 说明菜单数据已经存在，直接return
  if (store.state.routes.length > 0) {
    return;
  }
  getRequest('/system/config/menu').then(data => {
    if (data) {
      //格式化菜单
      let fmtedRoutes = formatRoutes(data);
      router.addRoutes(fmtedRoutes);
      //更新到某个方法内
      store.commit('initMenu', fmtedRoutes)
    }
  })
};
export const formatRoutes = (routes) => {
  let fmRoutes = [];
  routes.forEach(router => {
    let {
      path,
      component,
      name,
      meta,
      iconCls,
      children,
      enabled
    } = router;
    if (children && children instanceof Array) {
      children = formatRoutes(children);
    }
    let fmRouter = {
      path: path,
      name: name,
      iconCls: iconCls,
      meta: meta,
      children: children,
      enabled: enabled,
      component(resolve) {
        if (component.startsWith("Home")) {
          console.log(component)
          require(['../components/' + component + '.vue'], resolve);
        } else if (component.startsWith("Dep")) {
          require(['../components/dep/' + component + '.vue'], resolve);
        } else if (component.startsWith("Per")) {
          require(['../components/per/' + component + '.vue'], resolve);
        } else if (component.startsWith("Sal")) {
          require(['../components/sal/' + component + '.vue'], resolve);
        } else if (component.startsWith("Sta")) {
          require(['../components/sta/' + component + '.vue'], resolve);
        } else if (component.startsWith("Sys")) {
          require(['../components/sys/' + component + '.vue'], resolve);
        }
      }
    };
    fmRoutes.push(fmRouter);
  });
  return fmRoutes;
};
