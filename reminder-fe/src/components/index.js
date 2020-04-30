import Vue from 'vue'
import upperFirst from 'lodash/upperFirst'
import camelCase from 'lodash/camelCase'

const requireComponent = require.context('./app', true, /[A-Z]\w+\.(vue|js)$/);

requireComponent.keys().forEach(filePath => {
  let fileName = filePath.split('/').pop().replace(/\.\w+$/, '');

  const componentConfig = requireComponent(filePath)
  const componentName = upperFirst(camelCase(fileName));

  Vue.component(componentName, componentConfig.default || componentConfig)
})