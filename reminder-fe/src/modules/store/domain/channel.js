import  { 
  channelService,
  memberService
} from '@/modules/service'

import { CollectionUtils } from '@/utils/common'

const state = {
  channels: {
    created: [],
    involved: []    
  },
  createPopup: {
    createChannel: {
      title: '',
      description: '',
      active: false,
      publisherIds: []
    },
    searchMembers: [],
    selectPublisher: []
  }
}

const getters = {
  getSearchMemberPublishers(state) {
    const members = state.createPopup.searchMembers;
    const searchMemberPublishers = [];

    for(const member of members) {
      member.publishers.map(publisher => {
        publisher.name = member.profile.name;
        searchMemberPublishers.push(publisher);
      })
    }

    return searchMemberPublishers;
  }
}

const mutations = {
  initCreatePopup(state) { // todo
    state.createPopup = {};
  },
  setCreatedChannels(state, createdChannels) {
    state.channels.created = createdChannels;
  },
  setInvolvedChannels(state, involvedChannels) {
    state.channels.involved = involvedChannels;
  },
  removeChannel(state, channelIds) {
    channelIds.forEach(channelId => {
      CollectionUtils.remove(state.channels.created, e => e.id === channelId)
      CollectionUtils.remove(state.channels.involved, e => e.id === channelId)
    })
  },
  setCreateChannel(state, createChannel) {
    state.createPopup.createChannel = createChannel;
  },
  setSearchMembers(state, searchMembers) {
    state.createPopup.searchMembers = searchMembers;
  }
}

const actions = {
  async getCreatedChannels({ commit }, memberId) {
    let response = await channelService.getCreatedChannels(memberId);
    commit('setCreatedChannels', response.data.channels);
  },
  async getInvolvedChannels({ commit }, memberId) {
    let response = await channelService.getInvolvedChannels(memberId);
    commit('setInvolvedChannels', response.data.channels);
  },
  async getSearchMembers({ commit }, keyword) {
    let response = await memberService.getSearchMembers(keyword);
    commit('setSearchMembers', response.data.memberDetails);
  },
  deleteChannels({ commit }, channelIds) {
    channelService.deleteChannel(channelIds).then(() => {
      commit('removeChannel', channelIds);
    })
  }
}

export default {
  // 네임스페이스로 분할화된 모듈 처리
  namespaced: true,
  state,
  getters,
  mutations,
  actions
}