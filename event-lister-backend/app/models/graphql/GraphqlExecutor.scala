package models.graphql

import javax.inject.{ Inject, Singleton }

@Singleton
class GraphqlExecutor @Inject() (
                                masterSchema: MasterSchema,
                                masterContext: MasterContext
                                ) {

}
