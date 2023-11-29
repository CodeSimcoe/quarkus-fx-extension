package com.codesimcoe.quarkus.fx.extension.deployment;

import io.quarkus.deployment.IsDevelopment;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.annotations.BuildSteps;
import io.quarkus.devui.spi.page.CardPageBuildItem;
import io.quarkus.devui.spi.page.Page;

@BuildSteps(onlyIf = {IsDevelopment.class})
public class QuarkusFxDevUIProcessor {

  @BuildStep
  public CardPageBuildItem create() {
    CardPageBuildItem card = new CardPageBuildItem();
    card.addPage(
      Page.webComponentPageBuilder()
       .title("Quarkus Fx")
       .icon("font-awesome-solid:boxes-stacked")
    );
//    card.addPage(
//      Page.webComponentPageBuilder()
//        .title("Entity Types")
//        .componentLink("hibernate-orm-entity-types.js")
//        .icon("font-awesome-solid:table")
//        .dynamicLabelJsonRPCMethodName("getNumberOfEntityTypes")
//    );
//    card.addPage(
//      Page.webComponentPageBuilder()
//        .title("Named Queries")
//        .componentLink("hibernate-orm-named-queries.js")
//        .icon("font-awesome-solid:circle-question")
//        .dynamicLabelJsonRPCMethodName("getNumberOfNamedQueries")
//    );

    return card;
  }

//    @BuildStep
//    JsonRPCProvidersBuildItem createJsonRPCService() {
//        return new JsonRPCProvidersBuildItem(HibernateOrmDevJsonRpcService.class);
//    }
//
//    @BuildStep
//    AdditionalBeanBuildItem additionalBeans() {
//        return AdditionalBeanBuildItem
//                .builder()
//                .addBeanClass(HibernateOrmDevJsonRpcService.class)
//                .setUnremovable()
//                .setDefaultScope(DotNames.APPLICATION_SCOPED)
//                .build();
//    }
//
//    @BuildStep
//    void handleInitialSql(List<PersistenceUnitDescriptorBuildItem> persistenceUnitDescriptorBuildItems,
//            BuildProducer<JdbcInitialSQLGeneratorBuildItem> initialSQLGeneratorBuildItemBuildProducer) {
//        for (PersistenceUnitDescriptorBuildItem puDescriptor : persistenceUnitDescriptorBuildItems) {
//            String puName = puDescriptor.getPersistenceUnitName();
//            String dsName = puDescriptor.getConfig().getDataSource().orElse(PersistenceUnitUtil.DEFAULT_PERSISTENCE_UNIT_NAME);
//            initialSQLGeneratorBuildItemBuildProducer
//                    .produce(new JdbcInitialSQLGeneratorBuildItem(dsName, new HibernateOrmDevInfoCreateDDLSupplier(puName)));
//        }
//    }

}